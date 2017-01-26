package com.acme.usermanagement.acceptance.steps;

import static com.acme.usermanagement.domain.builder.UserBuilder.anUser;
import static com.google.common.base.Preconditions.checkNotNull;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.acme.usermanagement.application.UserManagementService;
import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.persistence.UserRepository;

@Component
public class UserSteps {
	
	protected Validator validator;
	
	protected UserRepository repository;
	
	protected UserManagementService service;
	
	public UserSteps(
			UserManagementService service, 
			UserRepository repository, 
			@Qualifier("userValidator") Validator validator) {
		
		checkNotNull(service);
		checkNotNull(repository);
		checkNotNull(validator);
		
		this.service = service;
		this.repository = repository;
		this.validator = validator;
	}

	public UserManagementService getService() {
		return service;
	}

	public UserRepository getRepository() {
		return repository;
	}
	
	public Validator getValidator() {
		return validator;
	}

	public User createRegisteredUser() {
		return repository.save(createNotRegisteredUser());
	}
	
	public User createNotRegisteredUser() {
		return anUser().build();
	}
	
	public boolean isValid(Object target) {
		checkNotNull(target);
		
		Errors errors = new BeanPropertyBindingResult(target, "target");
			
		this.getValidator().validate(target, errors);
			
		return ! errors.hasErrors();
	}
	
}