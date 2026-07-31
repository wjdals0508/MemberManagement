package com.example.membermanagement.domain.member.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private int age;

    private String mbti;

    private String profileImageUrl;

    public Member(String name, int age, String mbti, String profileImageUrl) {
        this.name = name;
        this.age = age;
        this.mbti = mbti;
        this.profileImageUrl = profileImageUrl;
    }

    public void updateProfileImage(String imageUrl) {
        this.profileImageUrl = imageUrl;
    }
}
