package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.MemberRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.member.CreateMemberRequest;
import com.aysavs.libraryApp.aplication.service.request.member.UpdateMemberRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateMemberRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.member.Member;
import com.aysavs.libraryApp.domain.aggragate.member.MemberStatus;
import com.aysavs.libraryApp.infrastructure.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private  final MemberRepository memberRepository;
    private final CreateMemberRequestValidator createMemberRequestValidator ;
    private final MemberRequestConverter memberRequestConverter;

    public MemberService(MemberRepository memberRepository
            ,CreateMemberRequestValidator createMemberRequestValidator
            , MemberRequestConverter memberRequestConverter
                         ) {
        this.memberRepository = memberRepository;
        this.memberRequestConverter=memberRequestConverter;
        this.createMemberRequestValidator=createMemberRequestValidator;
    }


    public List<Member> getAll() {
        return memberRepository.findAll(); // BookRepository üzerinden kitapları al
    }

    public Long create(CreateMemberRequest createMemberRequest ) {
        createMemberRequestValidator.validate(createMemberRequest);
        Member member  = memberRequestConverter.convert(createMemberRequest);
        Member savedMember = memberRepository.save(member);

        return(long) savedMember.getId();
    }
    public Long update(UpdateMemberRequest request, Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new NotFoundException("Member not found"));

        // İstekten gelen verileri uygula
        Optional.ofNullable(request.getName()).ifPresent(member::setName);
        Optional.ofNullable(request.getSurname()).ifPresent(member::setSurname);
        Optional.ofNullable(request.getMailAddress()).ifPresent(member::setMailAddress);
        Optional.ofNullable(request.getJob()).ifPresent(member::setJob);
        member.setGsmNumber(request.getGsmNumber()); // long türünde olduğu için null kontrolü gerekmez

        // Enum değerini kontrol ederek güncelle
        Optional.ofNullable(request.getStatus())
                .map(String::toUpperCase)
                .map(MemberStatus::valueOf)
                .ifPresent(member::setStatus);

        // Güncellenmiş veriyi kaydet
        memberRepository.save(member);

        return memberId; // Güncellenen üyenin ID'sini döndür
    }
    public void delete(Long memberId) {
        if (!memberRepository.existsById(memberId)) {
            throw new NotFoundException("Member with id " + memberId + " not found");
        }
        memberRepository.deleteById(memberId);
    }
}
