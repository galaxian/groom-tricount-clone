package com.example.tricountclone.member.service;

import java.util.Objects;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.member.dto.request.LoginReqDto;
import com.example.tricountclone.member.dto.request.SignupReqDto;
import com.example.tricountclone.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	@Transactional
	public void signUp(SignupReqDto reqDto) {
		String salt = passwordEncoder.generateSalt(reqDto.getPassword());
		String encryptedPassword = passwordEncoder.encrypt(reqDto.getPassword(), salt);

		Member member = new Member(reqDto.getIdentifier(), encryptedPassword, reqDto.getNickname(), salt);
		memberRepository.save(member);
	}

	@Transactional(readOnly = true)
	public void login(LoginReqDto reqDto) {
		Member member = memberRepository.findMemberByIdentifier(reqDto.getIdentifier())
			.orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

		if (member.isMatchedPassword(passwordEncoder.encrypt(reqDto.getPassword(), member.getSalt()))) {
			throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
		}
	}
}
