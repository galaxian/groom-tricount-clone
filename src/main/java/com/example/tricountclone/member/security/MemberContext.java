package com.example.tricountclone.member.security;

import com.example.tricountclone.member.domain.Member;

public class MemberContext {
	private static final ThreadLocal<Member> memberThreadLocal = new ThreadLocal<>();
	public static void setCurrentMember(Member member) {
		memberThreadLocal.set(member);
	}
	public static Member getCurrentMember() {
		return memberThreadLocal.get();
	}
}
