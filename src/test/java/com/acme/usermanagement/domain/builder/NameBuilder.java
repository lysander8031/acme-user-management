package com.acme.usermanagement.domain.builder;

import com.acme.usermanagement.domain.Name;

public class NameBuilder implements Builder<Name> {
	
	private String firstName;

	private String lastName;

	private NameBuilder() {
		this.firstName = DefaultProperty.FIRST_NAME;
		this.lastName = DefaultProperty.LAST_NAME;
	}
	
	public static NameBuilder aName() {
		return new NameBuilder();
	}

	@Override
	public Name build() {
		Name name = new Name(firstName, lastName);
		
		return name;
	}
	
	public NameBuilder withFirstName(String firstName) {
		this.firstName = firstName;
		
		return this;
	}
	
	public NameBuilder withLastName(String lastName) {
		this.lastName = lastName;
		
		return this;
	}
	
	public NameBuilder but() {
		return new NameBuilder()
				.withFirstName(firstName)
				.withLastName(lastName);
	}

}