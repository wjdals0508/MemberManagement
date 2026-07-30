package com.example.membermanagement.domain.member.controller;

import com.example.membermanagement.domain.member.dto.request.CreateMemberRequest;
import com.example.membermanagement.domain.member.dto.response.CreateMemberResponse;
import com.example.membermanagement.domain.member.dto.response.GetMemberResponse;
import com.example.membermanagement.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/api/members")
    public ResponseEntity<CreateMemberResponse> createMember(
            @Valid @RequestBody CreateMemberRequest request
    ) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @GetMapping("/api/members/{id}")
    public ResponseEntity<GetMemberResponse> getMember(
            @PathVariable long id
    ) {
        return ResponseEntity.ok(memberService.getMember(id));
    }
}
