package com.example.tricountclone.settlement.dto.response;

import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class FindSettlementResDto {

	private String name;
	private List<ExpenseInfoResDto> expenseInfoList;
}
