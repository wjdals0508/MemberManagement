package com.example.membermanagement.domain.member.repository;

import com.example.membermanagement.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
