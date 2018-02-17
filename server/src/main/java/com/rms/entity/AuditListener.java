package com.rms.entity;

import org.hibernate.envers.RevisionListener;
import org.springframework.security.core.context.SecurityContextHolder;

public class AuditListener implements RevisionListener {

	@Override
	public void newRevision(Object revisionEntity) {
		Audit audit = (Audit) revisionEntity;
		String email = SecurityContextHolder.getContext().getAuthentication().getName();
		audit.setEmail(email);
	}
}