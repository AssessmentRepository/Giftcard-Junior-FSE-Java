package com.giftcard.entitys;

import java.time.Instant;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document("User")
@Data
public class User {

	@Id
	private Long id = Instant.now().toEpochMilli();

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

	public User() {
	}

	public User(Long id, String username, String password, List<UserRole> roles) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.roles = roles;
	}

}
