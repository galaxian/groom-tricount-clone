package com.example.tricountclone.member.controller;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.tricountclone.member.dto.request.LoginReqDto;
import com.example.tricountclone.member.dto.request.SignupReqDto;
import com.example.tricountclone.member.service.MemberService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/signup")
	public ResponseEntity<Void> signup(@RequestBody SignupReqDto reqDto) {
		memberService.signUp(reqDto);
		return ResponseEntity.created(URI.create("/signup")).build();
	}

	@GetMapping("/login")
	public ResponseEntity<Void> login(@RequestBody LoginReqDto reqDto, HttpServletResponse response) {
		Long memberId = memberService.login(reqDto);

		Cookie idCookie = new Cookie("LOGIN_MEMBER_COOKIE", String.valueOf(memberId));
		response.addCookie(idCookie);
		return ResponseEntity.created(URI.create("/login")).build();
	}
}
