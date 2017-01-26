package com.acme.usermanagement.presentation.validator;

import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.acme.usermanagement.domain.Password;
import com.acme.usermanagement.presentation.form.ChangePasswordForm;

@Component
public class ChangePasswordFormValidator implements Validator {

	public ChangePasswordFormValidator() {}
	
	@Override
	public boolean supports(Class<?> clazz) {
		return ChangePasswordForm.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		checkNotNull(target);
		checkNotNull(errors);
		
		ChangePasswordForm form = (ChangePasswordForm) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "currentPassword", "currentPassword.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "newPassword", "newPassword.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmNewPassword", "confirmNewPassword.required");
		
		rejectIfNotSame(form.getCurrentUser().getCredential().getPassword().getValue(), form.getCurrentPassword(), errors);
		rejectIfSame(form.getCurrentPassword(), form.getNewPassword(), errors);
		rejectIfNotSame(form.getNewPassword(), form.getConfirmNewPassword(), errors);
		rejectIfWeak(form.getNewPassword(), errors);
		
	}

	private void rejectIfNotSame(String currentUserPassword, String currentPassword, Errors errors) {
		if (! errors.hasErrors()) {
			if (! isSame(currentUserPassword, currentPassword)) {
				errors.rejectValue("currentPassword", "currentPassword.norecord");
			}
		}
	}
	
	private void rejectIfSame(String currentPassword, String newPassword, Errors errors) {
		if (! errors.hasErrors()) {
			if (isSame(currentPassword, newPassword)) {
				errors.rejectValue("currentPassword", "currentPassword.nomatch");
			}
		}
	}
	
	private void rejectIfWeak(String password, Errors errors) {
		if (! errors.hasErrors()) {
			if (new Password(password).isWeak()) {
				errors.rejectValue("newPassword", "newPassword.weak");
			}
		}
	}
	
	private boolean isSame(String a, String b) {
		return a.equalsIgnoreCase(b);
	}

}