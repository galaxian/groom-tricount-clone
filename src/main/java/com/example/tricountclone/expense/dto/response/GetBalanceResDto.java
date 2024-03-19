package com.example.tricountclone.expense.dto.response;

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
}
