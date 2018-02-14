package com.rms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "group_user")
@Data
public class GroupUser {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "group_user_sequence")
	@SequenceGenerator(name="group_user_sequence", sequenceName = "group_user_seq", allocationSize=50)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@ManyToOne
	private Group group;
	
	@ManyToOne
	private User user;
}
