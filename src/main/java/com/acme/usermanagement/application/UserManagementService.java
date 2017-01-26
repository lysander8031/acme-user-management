package com.acme.usermanagement.application;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.domain.UserService;
import com.acme.usermanagement.persistence.UserRepository;

@Service
public class UserManagementService {
	
	private final UserService userService;
	
	private final UserRepository repository;
	
	public UserManagementService(UserService userService, UserRepository repository) {
		checkNotNull(userService);
		checkNotNull(repository);
		
		this.userService = userService;
		this.repository = repository;
	}
		
	@Transactional
	public User register(User user) throws IllegalStateException {
		checkNotNull(user);
		
		userService.register(user);
		
		return repository.save(user);
	}
	
	@Transactional
	public User changePassword(User user, String newPassword) {
		checkNotNull(user);
		checkNotNull(newPassword);
		
		user.changePassword(newPassword);
		
		return repository.save(user);
	}
	
}