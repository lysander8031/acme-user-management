package com.acme.usermanagement.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;

import com.acme.usermanagement.persistence.UserRepository;

@Component
public class UserService {
	
	private final UserRepository repository;

	public UserService(UserRepository repository) {
		checkNotNull(repository);
		
		this.repository = repository;
	}
	
	public User register(User user) {
		checkNotNull(user);
		
		if (isAlreadyRegistered(user))
			throw new IllegalStateException("User is already registered");	
		
		user.register();
		
		return user;
	}

	protected boolean isAlreadyRegistered(User user) {
		return repository.findByCredentialEmail(user.getEmail())
				 .isPresent();
	}

}