package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.UserBuilder.anUser;
import static org.junit.Assert.*;

import org.junit.Test;

public class UserTest {

	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenUserIsCreatedWithNullValue() {
		new User(null, null, null);
	}
	
	@Test
	public void shoulBeEqualToUserWithSameValue() {
		User one = anUser().build();
		User two = anUser().build();
		
		assertEquals(one, two);
	}

}