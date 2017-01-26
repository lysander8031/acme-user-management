package com.acme.usermanagement.acceptance.steps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.acme.usermanagement.application.UserManagementService;
import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.persistence.UserRepository;
import com.acme.usermanagement.presentation.form.ChangePasswordForm;

@Component
public class ChangeUserPasswordSteps extends UserSteps {
	
	public ChangeUserPasswordSteps(
			UserManagementService service, 
			UserRepository repository, 
			@Qualifier("changePasswordFormValidator") Validator validator) {
		
		super(service, repository, validator);
	}
	
	public void changePassword(User user, String newPassword) {
		ChangePasswordForm form = fillInChangePasswordForm(user, newPassword);
		
		if(isValid(form))
			doChangePassword(form);
	}

	private void doChangePassword(ChangePasswordForm form) {
		this.getService().changePassword(form.getCurrentUser(), form.getNewPassword());
	}
	
	private ChangePasswordForm fillInChangePasswordForm(User user, String newPassword) {
		ChangePasswordForm form = new ChangePasswordForm();
		form.setCurrentUser(user);
		form.setCurrentPassword(user.getPassword());
		form.setNewPassword(newPassword);
		form.setConfirmNewPassword(newPassword);
		
		return form;
	}
	
}