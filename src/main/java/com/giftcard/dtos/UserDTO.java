package com.giftcard.dtos;

import java.time.Instant;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;

import com.giftcard.entitys.UserRole;

public class UserDTO {
	@Id
	private Long id;

	@Email
	private String username;

	@NotEmpty
	@Pattern(regexp = "{A-Za-z0-9}@$")
	private String password;

	private List<UserRole> roles;

	private String companyname;

	private String gstin;

	private String aboutCompany;

	private String address;

	private String website;

	private String emailId;

	private String contactNumber;

	private Boolean userBlocked;

	private String streetName;

	private String cityName;

	private String state;

	private String country;

	private String pincode;

}
