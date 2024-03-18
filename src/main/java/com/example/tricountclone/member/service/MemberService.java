package com.example.tricountclone.member.service;

import org.springframework.stereotype.Service;

import com.example.tricountclone.member.domain.Member;
import com.example.tricountclone.member.dto.request.SignupReqDto;
import com.example.tricountclone.member.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;
	private final PasswordEncoder passwordEncoder;

	public void signUp(SignupReqDto reqDto) {
		String salt = passwordEncoder.generateSalt(reqDto.getPassword());
		String encryptedPassword = passwordEncoder.encrypt(reqDto.getPassword(), salt);

		Member member = new Member(reqDto.getIdentifier(), encryptedPassword, reqDto.getNickname(), salt);
		memberRepository.save(member);
	}
}
