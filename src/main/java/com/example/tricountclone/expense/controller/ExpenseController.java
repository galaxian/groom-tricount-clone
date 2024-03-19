package com.example.tricountclone.expense.controller;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tricountclone.expense.dto.request.CreateExpenseReqDto;
import com.example.tricountclone.expense.dto.response.GetBalanceResDto;
import com.example.tricountclone.expense.service.ExpenseService;
import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.member.security.MemberContext;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ExpenseController {

	private final ExpenseService expenseService;

	@PostMapping("/expense/{settlementId}")
	public ResponseEntity<Void> createExpense(@PathVariable("settlementId") Long settlementId,
		@RequestBody CreateExpenseReqDto reqDto) {
		expenseService.createExpense(settlementId, reqDto, MemberContext.getCurrentMember());
		return ResponseEntity.created(URI.create("/expense")).build();
	}

	@GetMapping("/expense/{settlementId}")
	public ResponseEntity<List<GetBalanceResDto>> getBalance(@PathVariable("settlementId") Long settlementId) {
		List<GetBalanceResDto> result = expenseService.getBalance(settlementId, MemberContext.getCurrentMember());
		return ResponseEntity.ok(result);
	}
}
