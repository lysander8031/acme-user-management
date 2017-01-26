package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.DefaultProperty.EMAIL;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EmailTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenEmailIsCreatedWithNullValue() {
		new Email(null);
	}
	
	@Test
	public void shoulBeEqualToEmailWithSameValue() {
		Email one = new Email(EMAIL);
		Email two = new Email(EMAIL);
		
		assertEquals(one, two);
	}

}