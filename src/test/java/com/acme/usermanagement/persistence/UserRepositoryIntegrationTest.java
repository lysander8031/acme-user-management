package com.acme.usermanagement.persistence;

import static com.acme.usermanagement.domain.builder.UserBuilder.anUser;
import static org.junit.Assert.*;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.acme.usermanagement.domain.User;

@PersistenceConfig
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryIntegrationTest  {
	
	private User newUser;
	
	@Autowired
	private UserRepository repository;
	
	@Before
	public void setup() {
		newUser = anUser().build();
	}
	
	@Test
	public void findUserByEmail() {
		User savedUser = repository.saveAndFlush(newUser);
		
		Optional<User> result = repository.findByCredentialEmail(savedUser.getEmail());
		
		assertTrue(result.isPresent());
	}

}