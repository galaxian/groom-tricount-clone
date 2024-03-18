package com.example.tricountclone.settlement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tricountclone.settlement.domain.Settlement;

@Repository
public interface SettlementRepository extends JpaRepository<Settlement,Long> {
}
