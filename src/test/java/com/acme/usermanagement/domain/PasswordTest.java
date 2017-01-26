package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.DefaultProperty.PASSWORD;
import static org.junit.Assert.*;

import org.junit.Test;

public class PasswordTest {
	
	@Test
	public void isPasswordWeak() {
		Password password = new Password("weak");
		
		assertTrue(password.isWeak());
	}
	
	@Test
	public void isPasswordStrong() {
		Password password = new Password("strong");
		
		assertFalse(password.isWeak());
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenPasswordIsCreatedWithNullValue() {
		new Password(null);
	}
	
	@Test
	public void shoulBeEqualToPasswordWithSameValue() {
		Password one = new Password(PASSWORD);
		Password two = new Password(PASSWORD);
		
		assertEquals(one, two);
	}

}