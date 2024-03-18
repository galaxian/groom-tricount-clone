package com.example.tricountclone.settlement.dto.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

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
}
