package com.acme.usermanagement.acceptance;

import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.usermanagement.acceptance.steps.ChangeUserPasswordSteps;
import com.acme.usermanagement.domain.User;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@CucumberConfig
public class ChangePasswordAcceptanceTest {
	
	private User user;
	
	@Autowired
	private ChangeUserPasswordSteps step;
	
	@Given("^I am a registered user$")
	public void iAmARegisteredUser() throws Throwable {
		user = step.createRegisteredUser();
	}

	@When("^I change my password to \"([^\"]*)\"$")
	public void iChangeMyPasswordTo(String newPassword) throws Throwable {
		step.changePassword(user, newPassword);
	}

	@Then("^my new password should be \"([^\"]*)\"$")
	public void myNewPasswordShouldBe(String newPassword) throws Throwable {
	    assertEquals(newPassword, user.getPassword());
	}
	
}