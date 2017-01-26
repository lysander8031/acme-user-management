package com.acme.usermanagement.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import org.springframework.data.jpa.domain.AbstractPersistable;

public class Entity extends AbstractPersistable<Long> implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private LocalDateTime created;
	
	private LocalDateTime updated;
	
	public Entity() {
		super();
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}	
	
}