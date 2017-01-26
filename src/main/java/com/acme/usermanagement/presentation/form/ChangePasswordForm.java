package com.acme.usermanagement.presentation.form;

import com.acme.usermanagement.domain.User;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class ChangePasswordForm {
	
	private User currentUser;
	
	private String currentPassword;
	
	private String newPassword; 
	
	private String confirmNewPassword;
	
	public ChangePasswordForm() {}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}

	public String getCurrentPassword() {
		return currentPassword;
	}

	public void setCurrentPassword(String currentPassword) {
		this.currentPassword = currentPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getConfirmNewPassword() {
		return confirmNewPassword;
	}

	public void setConfirmNewPassword(String confirmNewPassword) {
		this.confirmNewPassword = confirmNewPassword;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) return true;
		if (!(obj instanceof ChangePasswordForm)) return false;
		
		final ChangePasswordForm that = (ChangePasswordForm) obj;
		
		return Objects.equal(this.currentUser, that.currentUser)
			&& Objects.equal(this.currentPassword, that.currentPassword)
			&& Objects.equal(this.newPassword, that.newPassword)
			&& Objects.equal(this.confirmNewPassword, that.confirmNewPassword);
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(this.currentUser, this.currentPassword, this.newPassword, this.confirmNewPassword);
	}
	
	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				  .add("currentPassword", this.currentPassword)
				  .add("newPassword", this.newPassword)
				  .add("confirmNewPassword", this.confirmNewPassword)
				  .toString();
	}
	
}