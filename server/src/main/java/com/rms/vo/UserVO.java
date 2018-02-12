package com.rms.vo;

import com.rms.entity.User;

import lombok.Data;

@Data
public class UserVO {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;

	public User toEntity() {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setPassword(password);
		return user;
	}
}
