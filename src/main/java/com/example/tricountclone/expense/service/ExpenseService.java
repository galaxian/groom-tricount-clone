package com.example.tricountclone.expense.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tricountclone.expense.dto.request.CreateExpenseReqDto;
import com.example.tricountclone.expense.repository.ExpenseRepository;
import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.settlement.domain.Settlement;
import com.example.tricountclone.settlement.repository.SettlementRepository;
import com.example.tricountclone.userSettlement.repository.UserSettlementRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	private final SettlementRepository settlementRepository;
	private final UserSettlementRepository userSettlementRepository;

	@Transactional
	public void createExpense(Long settlementId, CreateExpenseReqDto reqDto, Member member) {
		Settlement settlement = settlementRepository.findById(settlementId)
			.orElseThrow(() -> new IllegalArgumentException("정산이 존재하지 않습니다."));

		if (!userSettlementRepository.existsByMemberId(member.getId())) {
			throw new IllegalArgumentException("참여한 정산이 아닙니다.");
		}
	}
}
