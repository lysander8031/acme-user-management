package com.acme.usermanagement.acceptance;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.usermanagement.acceptance.steps.RegistrerUserSteps;
import com.acme.usermanagement.domain.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberConfig
public class RegisterUserAcceptanceTest {
	
	private User user;
	
	@Autowired
	private RegistrerUserSteps step;
	
	@Given("I am not a registered user")
	public void iAmNotARegisteredUserr() throws Throwable {
		user = step.createNotRegisteredUser();
	}

	@When("I register")
	public void iRegister() throws Throwable {
		step.register(user);
	}

	@Then("I should be a registered user")
	public void iShouldBeARegisteredUser() throws Throwable {
	    assertTrue(user.isRegistered());
	}
	
	@Given("I am an already registered user")
	public void iAmAnAlreadyRegisteredUser() throws Throwable {
		user = step.createRegisteredUser();
	}

	@Then("I should not be allowed to register")
	public void iShouldNotBeAllowedToRegister() throws Throwable {
		assertFalse(user.isRegistered());
	}

}