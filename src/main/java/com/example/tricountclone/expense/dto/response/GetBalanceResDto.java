package com.example.tricountclone.expense.dto.response;

import com.example.tricountclone.expense.domain.Expense;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class GetBalanceResDto {
	private Long senderUserNo;
	private String senderUserName;
	private int sendAmount;
	private Long receiverUserNo;
	private String receiverUserName;

	public GetBalanceResDto(Expense expense, int totalAmount) {
		this.senderUserNo = expense.getMember().getId();
		this.senderUserName = expense.getMember().getIdentifier();
		this.sendAmount = totalAmount - expense.getAmount().intValue();
	}

	public void sendMember(Expense expense) {
		this.receiverUserNo = expense.getMember().getId();
		this.receiverUserName = expense.getMember().getIdentifier();
	}
}
