package com.example.membermanagement.domain.member.service;

import com.example.membermanagement.domain.member.dto.request.CreateMemberRequest;
import com.example.membermanagement.domain.member.dto.response.CreateMemberResponse;
import com.example.membermanagement.domain.member.dto.response.GetMemberResponse;
import com.example.membermanagement.domain.member.entity.Member;
import com.example.membermanagement.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public CreateMemberResponse createMember(CreateMemberRequest request) {

        Member member = new Member(
                request.getName(),
                request.getAge(),
                request.getMbti());

        memberRepository.save(member);

        return CreateMemberResponse.from(member);
    }

    public GetMemberResponse getMember(long id) {

        Member member = memberRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Member mot found")
        );

        return GetMemberResponse.from(member);
    }
}
