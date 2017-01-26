package com.acme.usermanagement.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Password implements Serializable {
	private static final long serialVersionUID = -8337647501997875743L;
	
	private String value;
	
	protected Password() {}

	public Password(String value) {
		checkNotNull(value);
		
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
	
	public boolean isWeak() {
		final int STRENGTH_THRESHOLD = 6;
		
		return this.value.length() < STRENGTH_THRESHOLD;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Password)) return false;
		
		final Password that = (Password) obj;
		
		return Objects.equal(this.value, that.value);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.value);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("value", this.value)
				  .toString();
	}

}