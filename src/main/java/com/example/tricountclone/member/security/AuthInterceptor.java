package com.example.tricountclone.member.security;

import org.springframework.web.servlet.HandlerInterceptor;

import com.example.tricountclone.member.repository.MemberRepository;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

	private final MemberRepository memberRepository;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		Cookie[] cookies = request.getCookies();
		// 쿠키에 약속된 값이 있으면, 값을 까서 로그인 유저인지 확인한다.
		if(!this.containsUserCookie(cookies)) {
			response.sendError(HttpServletResponse.SC_FORBIDDEN, "");
			return false;
		}

		for(Cookie cookie : cookies) {
			if("LOGIN_MEMBER_COOKIE".equals(cookie.getName())) {
				try {
					// cookie에서 아이디를 꺼내고, DB에서 이 아이디에 해당하는 Member객체를 조회해서, 얘를 ThreadLocal에 Set한다.
					MemberContext.setCurrentMember(memberRepository.findById(Long.parseLong(cookie.getValue())).orElseThrow());
				} catch(Exception e) {
					response.sendError(HttpServletResponse.SC_FORBIDDEN, "MEMBER set error" + e.getMessage());
				}
			}
		}
		return true;
	}

	private boolean containsUserCookie(Cookie[] cookies) {
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if("LOGIN_MEMBER_COOKIE".equals(cookie.getName())) {
					return true;
				}
			}
		}
		return false;
	}
}
