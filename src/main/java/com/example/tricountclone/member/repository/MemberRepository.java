package com.example.tricountclone.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tricountclone.member.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
