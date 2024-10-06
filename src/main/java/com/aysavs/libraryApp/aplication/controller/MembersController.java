package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.MemberService;
import com.aysavs.libraryApp.domain.aggragate.member.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/members")
public class MembersController {
    private  final MemberService memberService;

    @GetMapping
    public List<Member> getAll() {

        return memberService.getAll(); //
    }

}
