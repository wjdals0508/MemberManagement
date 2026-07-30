package com.example.membermanagement.domain.member.dto.response;

import com.example.membermanagement.domain.member.entity.Member;

public record CreateMemberResponse(
        long id,
        String name,
        int age,
        String mbti
) {
    public static CreateMemberResponse from (Member member) {

        return new CreateMemberResponse(
                member.getId(),
                member.getName(),
                member.getAge(),
                member.getMbti());
    }
}
