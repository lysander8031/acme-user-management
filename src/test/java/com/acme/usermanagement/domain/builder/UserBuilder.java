package com.acme.usermanagement.domain.builder;

import static com.acme.usermanagement.domain.builder.AddressBuilder.anAddress;
import static com.acme.usermanagement.domain.builder.CredentialBuilder.aCredential;
import static com.acme.usermanagement.domain.builder.NameBuilder.aName;

import com.acme.usermanagement.domain.Address;
import com.acme.usermanagement.domain.Credential;
import com.acme.usermanagement.domain.Name;
import com.acme.usermanagement.domain.User;

public class UserBuilder implements Builder<User> {
	
	private Name name;
	
	private Address address;
	
	private Credential credential;

	private UserBuilder() {
		this.name = aName().build();;
		this.address = anAddress().build();;
		this.credential = aCredential().build();;
	}
	
	public static UserBuilder anUser() {
		return new UserBuilder();
	}

	@Override
	public User build() {
		User user = new User(name, address, credential);
		
		return user;
	}
	
	public UserBuilder withFirstName(String value) {
		this.name = aName().withFirstName(value).build();
		
		return this;
	}
	
	public UserBuilder withNoFirstName() {
		return withFirstName("");
	}
	
	public UserBuilder withLastName(String value) {
		this.name = aName().withLastName(value).build();
		
		return this;
	}
	
	public UserBuilder withNoLastName() {
		return withLastName("");
	}
	
	public UserBuilder withStreet(String value) {
		this.address = anAddress().withStreet(value).build();
		
		return this;
	}

	public UserBuilder withNoStreet() {
		return withStreet("");
	}
	
	public UserBuilder withCity(String value) {
		this.address = anAddress().withCity(value).build();
		
		return this;
	}

	public UserBuilder withNoCity() {
		return withCity("");
	}
	
	public UserBuilder withEmail(String value) {
		this.credential = aCredential().withEmail(value).build();
		
		return this;
	}

	public UserBuilder withInvalidEmail() {
		return withEmail("no@domain");
	}
	
	public UserBuilder withNoEmail() {
		return withEmail("");
	}
	
	public UserBuilder withPassword(String value) {
		this.credential = aCredential().withPassword(value).build();
		
		return this;
	}

	public UserBuilder withWeakPassword() {
		return withPassword("weak");
	}
	
	public UserBuilder withNoPassword() {
		return withPassword("");
	}

}