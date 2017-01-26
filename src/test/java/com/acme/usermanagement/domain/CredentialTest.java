package com.acme.usermanagement.domain;

import static com.acme.usermanagement.domain.builder.CredentialBuilder.aCredential;
import static org.junit.Assert.*;

import org.junit.Test;

public class CredentialTest {
	
	@Test
	public void changePassword() {
		String newPassword = "strong";
		
		Credential credential = aCredential().build();
		credential.changePassword(newPassword);
		
		assertEquals(newPassword, credential.getPassword().getValue());
	}
	
	@Test(expected=NullPointerException.class)
	public void shouldThrowExceptionWhenCredentialIsCreatedWithNullValue() {
		new Credential(null, null);
	}
	
	@Test
	public void shoulBeEqualToCredentialWithSameValue() {
		Credential one = aCredential().build();
		Credential two = aCredential().build();
		
		assertEquals(one, two);
	}

}