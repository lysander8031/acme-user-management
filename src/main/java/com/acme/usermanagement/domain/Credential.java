package com.acme.usermanagement.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import java.io.Serializable;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class Credential implements Serializable {
	private static final long serialVersionUID = 2113068502952960858L;

	private Email email;
	
	private Password password;

	protected Credential() {}
	
	public Credential(Email email, Password password) {
		checkNotNull(email);
		checkNotNull(password);
		
		this.email = email;
		this.password = password;
	}

	public Email getEmail() {
		return email;
	}

	public Password getPassword() {
		return password;
	}
	
	public void changePassword(String newPassword) {
		this.password = new Password(newPassword);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof Credential)) return false;
		
		final Credential that = (Credential) obj;
		
		return Objects.equal(this.email, that.email)
			&& Objects.equal(this.password, that.password);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.email, this.password);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("email", this.email)
				  .add("password", this.password)
				  .toString();
	}

}