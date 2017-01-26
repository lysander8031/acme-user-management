package com.acme.usermanagement.application;

import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.domain.UserService;
import com.acme.usermanagement.persistence.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserManagementServiceTest {
	
	@Mock 
	private User user;
	
	@Mock 
	private UserService userService;
	
	@Mock 
	private UserRepository repository;
	
	private UserManagementService service;
	
	@Before
	public void setup() {
		this.service = new UserManagementService(userService, repository);
	}

	@Test
	public void registerUser() {
		service.register(user);
		
		verify(userService).register(user);
		
		verify(repository).save(user);
	}
	
	@Test
	public void changeUserPassword() {
		service.changePassword(user, "secret");
		
		verify(user).changePassword("secret");
		
		verify(repository).save(user);
	}
	
}