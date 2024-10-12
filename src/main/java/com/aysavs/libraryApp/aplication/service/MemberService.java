package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.aplication.service.converter.MemberRequestConverter;
import com.aysavs.libraryApp.aplication.service.request.CreateMemberRequest;
import com.aysavs.libraryApp.aplication.service.validator.CreateMemberRequestValidator;
import com.aysavs.libraryApp.domain.aggragate.member.Member;
import com.aysavs.libraryApp.infrastructure.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
