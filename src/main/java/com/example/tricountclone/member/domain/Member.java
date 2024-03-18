package com.example.tricountclone.member.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Member {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;

	@Column(nullable = false, unique = true)
	private String identifier;

	@Column(nullable = false)
	private String encryptedPassword;

	@Column(nullable = false, unique = true)
	private String nickname;

	@Column(nullable = false)
	private String salt;

	public Member(String identifier, String encryptedPassword, String nickname, String salt) {
		this.identifier = identifier;
		this.encryptedPassword = encryptedPassword;
		this.nickname = nickname;
		this.salt = salt;
	}

	public boolean isMatchedPassword(String encryptedPassword) {
		return this.encryptedPassword.equals(encryptedPassword);
	}
}
