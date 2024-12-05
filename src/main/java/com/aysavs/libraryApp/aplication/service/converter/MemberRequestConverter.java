package com.aysavs.libraryApp.aplication.service.converter;

import com.aysavs.libraryApp.aplication.service.request.member.CreateMemberRequest;
import com.aysavs.libraryApp.domain.aggragate.member.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberRequestConverter {

    public Member convert(CreateMemberRequest createMemberRequest){
        Member member= new Member();
        member.setName(createMemberRequest.getName());
        member.setSurname(createMemberRequest.getSurname());
        member.setGsmNumber(createMemberRequest.getGsmNumber());
        member.setJob(createMemberRequest.getJob());
        member.setMailAddress(createMemberRequest.getMailAddress());
        return member;


    }
}
