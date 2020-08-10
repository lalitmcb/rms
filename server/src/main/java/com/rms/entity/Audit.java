package com.rms.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import org.hibernate.envers.RevisionEntity;
import org.hibernate.envers.RevisionNumber;
import org.hibernate.envers.RevisionTimestamp;

import lombok.Data;

@Entity(name = "audit")
@RevisionEntity(AuditListener.class)
@Data
public class Audit implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "audit_sequence")
	@SequenceGenerator(name = "audit_sequence", sequenceName = "audit_seq")
	@Column(name = "id", updatable = false, nullable = false)
	@RevisionNumber
	private Long id;

	@RevisionTimestamp
	private Long timestamp;

	@Column(name = "email")
	private String email;
}
