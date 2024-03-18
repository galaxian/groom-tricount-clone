package com.example.tricountclone.settlement.dto.reqest;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class CreateSettlementReqDto {
	private String name;
}
