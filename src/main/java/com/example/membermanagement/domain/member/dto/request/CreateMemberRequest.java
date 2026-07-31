package com.example.membermanagement.domain.member.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

@Getter
public class CreateMemberRequest {

    @NotNull
    private String name;

    private int age;

    @Size(min = 4, max = 4)
    private String mbti;

    private String profileImageUrl;
}
