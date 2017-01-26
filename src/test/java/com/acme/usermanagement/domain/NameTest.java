package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.NameBuilder.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class NameTest {
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenNameIsCreatedWithNullValue() {
		new Name(null, null);
	}
	
	@Test
	public void shoulBeEqualToNameWithSameValue() {
		Name one = aName().build();
		Name two = aName().build();
		
		assertEquals(one, two);
	}

}