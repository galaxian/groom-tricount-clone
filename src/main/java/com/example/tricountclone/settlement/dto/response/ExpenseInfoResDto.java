package com.example.tricountclone.settlement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.tricountclone.expense.domain.Expense;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExpenseInfoResDto {

	private String expenseName;
	private String userName;
	private BigDecimal amount;
	private LocalDateTime expenseDate;

	public ExpenseInfoResDto(Expense expense) {
		this.expenseName = expense.getName();
		this.userName = expense.getMember().getNickname();
		this.amount = expense.getAmount();
		this.expenseDate = expense.getCreatedAt();
	}
}
