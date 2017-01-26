package com.acme.usermanagement.domain.builder;

import com.acme.usermanagement.domain.Address;

public class AddressBuilder implements Builder<Address> {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zip;

	private AddressBuilder() {
		this.street = DefaultProperty.STREET;
		this.city = DefaultProperty.CITY;
		this.state = DefaultProperty.STATE;
		this.zip = DefaultProperty.ZIP;
	}
	
	public static AddressBuilder anAddress() {
		return new AddressBuilder();
	}

	@Override
	public Address build() {
		Address address = new Address(street, city, state, zip);
		
		return address;
	}
	
	public AddressBuilder withStreet(String street) {
		this.street = street;
		
		return this;
	}
	
	public AddressBuilder withCity(String city) {
		this.city = city;
		
		return this;
	}
	

	public AddressBuilder withState(String state) {
		this.state = state;
		
		return this;
	}
	
	public AddressBuilder withZip(String zip) {
		this.zip = zip;
		
		return this;
	}
	
	public AddressBuilder but() {
		return new AddressBuilder()
				.withStreet(street)
				.withCity(city)
				.withState(state)
				.withZip(zip);
	}

}