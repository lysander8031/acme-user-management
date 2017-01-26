package com.acme.usermanagement.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Address {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	protected Address() {}
	
	public Address(String street, String city, String state, String zip) {
		checkNotNull(street);
		checkNotNull(city);
		checkNotNull(state);
		checkNotNull(zip);
		
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}

	public String getZip() {
		return zip;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Address)) return false;
		
		final Address that = (Address) obj;
		
		return Objects.equal(this.street, that.street)
			&& Objects.equal(this.city, that.city)
			&& Objects.equal(this.state, that.state)
			&& Objects.equal(this.zip, that.zip);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.street, this.city, this.state, this.zip);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("street", this.street)
				  .add("city", this.city)
				  .add("state", this.state)
				  .add("zip", this.zip)
				  .toString();
	}
	
}