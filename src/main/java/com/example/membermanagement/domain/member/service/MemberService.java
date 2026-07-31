package com.example.membermanagement.domain.member.service;

import com.example.membermanagement.common.service.S3Service;
import com.example.membermanagement.domain.member.dto.request.CreateMemberRequest;
import com.example.membermanagement.domain.member.dto.response.CreateMemberResponse;
import com.example.membermanagement.domain.member.dto.response.GetMemberResponse;
import com.example.membermanagement.domain.member.dto.response.UploadProfileImgResponse;
import com.example.membermanagement.domain.member.entity.Member;
import com.example.membermanagement.domain.member.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final S3Service s3Service;

    @Transactional
    public CreateMemberResponse createMember(CreateMemberRequest request) {

        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti(),
                request.getProfileImageUrl()
        );

        memberRepository.save(member);

        return CreateMemberResponse.from(member);
    }

    @Transactional(readOnly = true)
    public GetMemberResponse getMember(long id) {

        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member mot found")
        );

        return GetMemberResponse.from(member);
    }

    @Transactional
    public UploadProfileImgResponse uploadProfileImg(long id, MultipartFile file) {

        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member mot found")
        );

        // 기존 이미지 있으면 삭제
        s3Service.delete(member.getProfileImageUrl());

        // upload
        String key = s3Service.uploadProfile(file);
        member.updateProfileImage(key);

        return new UploadProfileImgResponse(key);
    }

}
