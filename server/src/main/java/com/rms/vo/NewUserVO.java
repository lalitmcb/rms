package com.rms.vo;

import com.rms.entity.User;
import com.rms.security.Role;

import lombok.Data;

@Data
public class NewUserVO {
	
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private Role role;
	
	public User toEntity() {
		User user = new User();
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setRole(role);
		return user;
	}

}
