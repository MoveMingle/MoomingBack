package com.example.mooming.repository;

import com.example.mooming.domain.members.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);       // 중복 회원 검사 메서드
}