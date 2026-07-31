package com.example.membermanagement.domain.member.controller;

import com.example.membermanagement.common.service.S3Service;
import com.example.membermanagement.domain.member.dto.request.CreateMemberRequest;
import com.example.membermanagement.domain.member.dto.response.CreateMemberResponse;
import com.example.membermanagement.domain.member.dto.response.GetMemberResponse;
import com.example.membermanagement.domain.member.dto.response.GetProfileImgResponse;
import com.example.membermanagement.domain.member.dto.response.UploadProfileImgResponse;
import com.example.membermanagement.domain.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.net.URL;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberController {

    private final MemberService memberService;
    private final S3Service s3Service;

    @PostMapping("")
    public ResponseEntity<CreateMemberResponse> createMember(
            @Valid @RequestBody CreateMemberRequest request
    ) {
        return ResponseEntity.ok(memberService.createMember(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GetMemberResponse> getMember(
            @PathVariable long id
    ) {
        return ResponseEntity.ok(memberService.getMember(id));
    }

    @PostMapping("/{id}/profile-image")
    public ResponseEntity<UploadProfileImgResponse> uploadProfile(
            @PathVariable long id,
            @RequestParam("file") MultipartFile file
    ) {
        UploadProfileImgResponse result = memberService.uploadProfileImg(id, file);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/{id}/profile-image")
    public ResponseEntity<GetProfileImgResponse> getDownloadUrl(@RequestParam String key) {
        URL url = s3Service.getDownloadUrl(key);
        return ResponseEntity.ok(new GetProfileImgResponse(url.toString()));
    }
}
