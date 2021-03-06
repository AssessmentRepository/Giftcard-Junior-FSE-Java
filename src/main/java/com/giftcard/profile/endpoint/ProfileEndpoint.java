package com.giftcard.profile.endpoint;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.giftcard.security.auth.JwtAuthenticationToken;
import com.giftcard.security.model.UserContext;


public class ProfileEndpoint {
	 @RequestMapping(value="/api/me", method=RequestMethod.GET)
	    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
	        return (UserContext) token.getPrincipal();
	    }
	}