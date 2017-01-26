package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.AddressBuilder.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddressTest {
	
	@Test(expected=NullPointerException.class)
	public void throwsExceptionWhenAddressIsCreatedWithNullValues() {
		new Address(null, null, null, null);
	}
	
	@Test
	public void shoulBeEqualToAddressWithSameValue() {
		Address one = anAddress().build();
		Address two = anAddress().build();
		
		assertEquals(one, two);
	}

}