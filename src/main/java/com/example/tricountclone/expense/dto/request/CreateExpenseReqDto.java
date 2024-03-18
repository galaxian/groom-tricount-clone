package com.example.tricountclone.expense.dto.request;

import java.math.BigDecimal;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateExpenseReqDto {
	private String name;
	private BigDecimal amount;
}
