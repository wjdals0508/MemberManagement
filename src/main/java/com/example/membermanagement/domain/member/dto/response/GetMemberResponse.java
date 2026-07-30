package com.example.membermanagement.domain.member.dto.response;

import com.example.membermanagement.domain.member.entity.Member;

public record GetMemberResponse(
        long id,
        String name,
        int age,
        String mbti
) {
    public static GetMemberResponse from (Member member) {

        return new GetMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti());
    }
}
