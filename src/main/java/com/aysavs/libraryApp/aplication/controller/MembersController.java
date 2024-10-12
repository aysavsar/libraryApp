package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.MemberService;
import com.aysavs.libraryApp.aplication.service.request.CreateAuthorRequest;
import com.aysavs.libraryApp.aplication.service.request.CreateMemberRequest;
import com.aysavs.libraryApp.domain.aggragate.member.Member;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/create")
    public ResponseEntity<Long> create(@Valid @RequestBody CreateMemberRequest createMemberRequest) {
        Long createdMemberId = memberService.create(createMemberRequest);
        return ResponseEntity.ok(createdMemberId);
    }
}
