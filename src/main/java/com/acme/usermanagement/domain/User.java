package com.acme.usermanagement.domain;

import static com.google.common.base.Preconditions.checkNotNull;

import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;

public class User extends Entity {
	private static final long serialVersionUID = -4046155495724098497L;

	private Status status;
	
	private Name name;
	
	private Address address;
	
	private Credential credential;
	
	protected User() {}
	
	public User(Name name, Address address, Credential credential) {
		this(name, address, credential, Status.NOTREGISTERED);
	}
	
	public User(Name name, Address address, Credential credential, Status status) {
		checkNotNull(name);
		checkNotNull(address);
		checkNotNull(credential);
		checkNotNull(status);
		
		this.name = name;
		this.address = address;
		this.credential = credential;
		this.status = status;
	}
	
	public User(User user) {
		this.name = user.name;
		this.address = user.address;
		this.credential = user.credential;
		this.status = user.status;
	}

	public Status getStatus() {
		return status;
	}
	
	public Name getName() {
		return name;
	}
	
	public String getFormattedName() {
		return name.getFormattedName();
	}

	public Address getAddress() {
		return address;
	}

	public Credential getCredential() {
		return credential;
	}
	
	public Email getEmail() {
		return credential.getEmail();
	}
	
	public String getPassword() {
		return getCredential().getPassword().getValue();
	}
	
	public void register() {
		this.status = Status.REGISTERED;
	}

	public boolean isRegistered() {
		return Status.REGISTERED.equals(this.status);
	}
	
	public void changePassword(String newPassword) {
		this.credential.changePassword(newPassword);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof User)) return false;
		
		final User that = (User) obj;
		
		return Objects.equal(super.getId(), that.getId())
			&& Objects.equal(this.name, that.name)
			&& Objects.equal(this.address, that.address)
			&& Objects.equal(this.credential, that.credential);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(super.getId(), this.name, this.address, this.credential);
	}
	
	@Override
	public String toString() {
		return toStringHelper().toString();
	}

	protected ToStringHelper toStringHelper() {
		return MoreObjects.toStringHelper(this)
				  .add("id", super.getId())
				  .add("name", this.name)
				  .add("status", this.status)
				  .add("address", this.address)
				  .add("credential", this.credential);
	}

	

		
}