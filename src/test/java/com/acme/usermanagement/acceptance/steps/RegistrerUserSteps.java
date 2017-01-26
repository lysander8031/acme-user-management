package com.acme.usermanagement.acceptance.steps;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.Validator;

import com.acme.usermanagement.application.UserManagementService;
import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.persistence.UserRepository;

@Component
public class RegistrerUserSteps extends UserSteps {
	
	public RegistrerUserSteps(
			UserManagementService service, 
			UserRepository repository, 
			@Qualifier("userValidator") Validator validator) {
		
		super(service, repository, validator);
	}

	public void register(User user) {
		if (isValid(user))
			doRegister(user);
	}	
	
	private void doRegister(User user) {
		try {
			this.service.register(user);
		} catch (IllegalStateException e) { }
	}
	
}