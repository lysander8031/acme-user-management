package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.UserBuilder.anUser;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.acme.usermanagement.persistence.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {
	
	@Mock 
	private UserRepository repository;
	
	private User user;
	
	private UserService userService;
	
	@Before
	public void setup() {
		this.user = anUser().build();
		this.userService = new UserService(repository);
	}

	@Test
	public void registerNewUser() {
		givenUserIsAlreadyRegistered(false);
		
		whenUserRegisters();
		
		assertTrue(user.isRegistered());
	}

	@Test(expected=IllegalStateException.class)
	public void registerExistingUser() {
		givenUserIsAlreadyRegistered(true);
		
		whenUserRegisters();
	}
	
	private void givenUserIsAlreadyRegistered(boolean isRegistered) {
		this.userService = new UserService(repository) {
			protected boolean isAlreadyRegistered(User user) {
				return isRegistered;
			}
		};
	}
	
	private void whenUserRegisters() {
		userService.register(user);
	}
	
}