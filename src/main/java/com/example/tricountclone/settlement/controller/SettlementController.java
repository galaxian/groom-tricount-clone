package com.example.tricountclone.settlement.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tricountclone.member.security.MemberContext;
import com.example.tricountclone.settlement.dto.reqest.CreateSettlementReqDto;
import com.example.tricountclone.settlement.service.SettlementService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class SettlementController {

	private final SettlementService settlementService;

	@PostMapping("/settlements")
	public ResponseEntity<Void> createSettlement(@RequestBody CreateSettlementReqDto reqDto) {
		settlementService.createSettlement(reqDto, MemberContext.getCurrentMember());
		return ResponseEntity.created(URI.create("/settlements")).build();
	}
}
