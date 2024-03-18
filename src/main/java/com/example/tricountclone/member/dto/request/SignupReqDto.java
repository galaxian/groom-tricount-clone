package com.example.tricountclone.member.dto.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class SignupReqDto {
	private String identifier;
	private String password;
	private String nickname;
}
