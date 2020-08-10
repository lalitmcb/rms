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

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "groups_sequence")
	@SequenceGenerator(name = "groups_sequence", sequenceName = "groups_seq")
	@Column(name = "id", updatable = false, nullable = false)
	private Long id;

	@Column(name = "name")
	private String name;

}
