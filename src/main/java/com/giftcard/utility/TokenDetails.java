package com.giftcard.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.giftcard.entitys.User;
import com.giftcard.exceptionutility.BadRequestException;
import com.giftcard.security.JWTUtil;

@Component
public class TokenDetails {

	@Autowired
	private JWTUtil jwtUtil;
	
	public void validateUser(String token, String role) {
		User user = jwtUtil.parseToken(token);
		if (!user.getRoles().get(0).getRole().name().equals(role)) {
			throw new BadRequestException("Un Authorized Role to do actions");
		}
	}

	public String getUserName(String token) {
		User user = jwtUtil.parseToken(token);
		return user.getUsername();
	}
}
