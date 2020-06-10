package com.giftcard.utilityclasses;

import com.giftcard.entitys.User;

public class UserData {
	public static User getUserDetails() {
		User user = new User();
		user.setId(1L);
		user.setUsername("Shashidhar");
		user.setPassword("1234");
//		user.setRoles(List<UserRole> );
		user.setCompanyname("Google");
		user.setGstin("GSTIN001");
		user.setAboutCompany("E-Com");
		user.setAddress("BLR");
		user.setWebsite("www.google.com");
		user.setEmailId("email@gmail.com");
		user.setContactNumber("9494879694");
		user.setUserBlocked(false);
		return user;
		
	}
}
