package com.rms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "Users")
@Data
public class User implements Serializable {
		
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_sequence")
	@SequenceGenerator(name="users_sequence", sequenceName = "users_sequence", allocationSize=50)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
}
