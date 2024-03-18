package com.example.tricountclone.settlement.service;

import org.springframework.stereotype.Service;

import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.settlement.domain.Settlement;
import com.example.tricountclone.settlement.dto.reqest.CreateSettlementReqDto;
import com.example.tricountclone.settlement.repository.SettlementRepository;
import com.example.tricountclone.userSettlement.domain.UserSettlement;
import com.example.tricountclone.userSettlement.repository.UserSettlementRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SettlementService {

	private final SettlementRepository settlementRepository;
	private final UserSettlementRepository userSettlementRepository;

	public void createSettlement(CreateSettlementReqDto reqDto, Member member) {
		Settlement settlement = new Settlement(reqDto.getName());
		settlementRepository.save(settlement);

		UserSettlement userSettlement = new UserSettlement(member, settlement);
		userSettlementRepository.save(userSettlement);
	}
}
