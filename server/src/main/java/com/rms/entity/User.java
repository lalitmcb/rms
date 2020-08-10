package com.rms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.envers.AuditTable;
import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.rms.security.Role;
import com.rms.vo.UserVO;

import lombok.Data;

@Entity
@Table(name = "users")
@Audited
@AuditTable(value = "zzz_users_aud")
@Data
public class User implements Serializable {
		
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_seq")
	@SequenceGenerator(name="users_seq", sequenceName = "users_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	@NotAudited
	private String password;
	
	@Column(name="role") 
	@Enumerated(EnumType.STRING)
	private Role role;

	public UserVO toVO() {
		UserVO userVO = new UserVO();
		userVO.setId(id);
		userVO.setFirstName(firstName);
		userVO.setLastName(lastName);
		userVO.setEmail(email);
		userVO.setRole(role);
		return userVO;
	}
}
