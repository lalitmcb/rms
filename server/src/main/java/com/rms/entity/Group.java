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
@Table(name = "groups")
@Data
public class Group implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_sequence")
	@SequenceGenerator(name="groups_sequence", sequenceName = "groups_sequence", allocationSize=50)
	@Column(name = "id", updatable = false, nullable = false)
	private Integer id;
	
	@Column(name="name")
	private String name;
	
}
