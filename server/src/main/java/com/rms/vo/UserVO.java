
package com.rms.vo;

import com.rms.entity.User;
import com.rms.security.Role;

import lombok.Data;

@Data
public class UserVO {
	private Long id;
	private String firstName;
	private String lastName;
	private String email;
	private Role role;

	public User toEntity() {
		User user = new User();
		user.setId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setEmail(email);
		user.setRole(role);
		return user;
	}
}
