package com.aysavs.libraryApp.aplication.controller;

import com.aysavs.libraryApp.aplication.service.MemberService;
import com.aysavs.libraryApp.aplication.service.request.member.CreateMemberRequest;
import com.aysavs.libraryApp.aplication.service.request.member.UpdateMemberRequest;
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
    @PutMapping("/{memberId}/update")
    public ResponseEntity<Long> updateMember(@PathVariable Long memberId,
                                             @Valid @RequestBody UpdateMemberRequest request) {
        Long updatedMemberId = memberService.update(request, memberId);
        return ResponseEntity.ok(updatedMemberId);
    }
    @DeleteMapping("/{memberId}/delete")
    public ResponseEntity<Void> deleteMember(@PathVariable Long memberId) {
        memberService.delete(memberId);
        return ResponseEntity.noContent().build();
    }
}
