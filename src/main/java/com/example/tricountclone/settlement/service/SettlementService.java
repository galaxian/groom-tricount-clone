package com.example.tricountclone.settlement.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.settlement.domain.Settlement;
import com.example.tricountclone.settlement.dto.reqest.CreateSettlementReqDto;
import com.example.tricountclone.settlement.dto.response.FindSettlementResDto;
import com.example.tricountclone.settlement.repository.SettlementRepository;
import com.example.tricountclone.userSettlement.domain.UserSettlement;
import com.example.tricountclone.userSettlement.repository.UserSettlementRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SettlementService {

	private final SettlementRepository settlementRepository;
	private final UserSettlementRepository userSettlementRepository;

	@Transactional
	public void createSettlement(CreateSettlementReqDto reqDto, Member member) {
		Settlement settlement = new Settlement(reqDto.getName());
		settlementRepository.save(settlement);

		UserSettlement userSettlement = new UserSettlement(member, settlement);
		userSettlementRepository.save(userSettlement);
	}

	@Transactional
	public void joinSettlement(Long settlementId, Member member) {
		Settlement settlement = settlementRepository.findById(settlementId)
			.orElseThrow(() -> new IllegalArgumentException("정산이 존재하지 않습니다."));

		UserSettlement userSettlement = new UserSettlement(member, settlement);
		userSettlementRepository.save(userSettlement);
	}

	@Transactional(readOnly = true)
	public FindSettlementResDto findSettlement(Long settlementId, Member member) {
		if (!userSettlementRepository.existsByMemberId(member.getId())) {
			throw new IllegalArgumentException("참여한 정산이 아닙니다.");
		}
		Settlement settlement = settlementRepository.findById(settlementId)
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 정산입니다."));

	}
}
