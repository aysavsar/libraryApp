package com.aysavs.libraryApp.aplication.service;

import com.aysavs.libraryApp.domain.aggragate.member.Member;
import com.aysavs.libraryApp.infrastructure.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MemberService {

    private  final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public List<Member> getAll() {
        return memberRepository.findAll(); // BookRepository üzerinden kitapları al
    }
}
