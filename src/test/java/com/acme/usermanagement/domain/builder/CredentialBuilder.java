package com.acme.usermanagement.domain.builder;

import com.acme.usermanagement.domain.Credential;
import com.acme.usermanagement.domain.Email;
import com.acme.usermanagement.domain.Password;

public class CredentialBuilder implements Builder<Credential> {
	
	private String email;
	
	private String password;

	private CredentialBuilder() {
		this.email = DefaultProperty.EMAIL;
		this.password = DefaultProperty.PASSWORD;
	}
	
	public static CredentialBuilder aCredential() {
		return new CredentialBuilder();
	}

	@Override
	public Credential build() {
		Credential credential = new Credential(new Email(email), new Password(password));
		
		return credential;
	}
	
	public CredentialBuilder withEmail(String email) {
		this.email = email;
		
		return this;
	}
	
	public CredentialBuilder withPassword(String password) {
		this.password = password;
		
		return this;
	}
	
	public CredentialBuilder but() {
		return new CredentialBuilder()
				.withEmail(email)
				.withPassword(password);
	}

}