package com.example.tricountclone.userSettlement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tricountclone.userSettlement.domain.UserSettlement;

public interface UserSettlementRepository extends JpaRepository<UserSettlement, Long> {
	boolean existsByMemberId(Long id);
}
