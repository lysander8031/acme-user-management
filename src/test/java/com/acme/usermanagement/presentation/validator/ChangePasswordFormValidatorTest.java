package com.acme.usermanagement.presentation.validator;

import static com.acme.usermanagement.domain.builder.UserBuilder.anUser;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.acme.usermanagement.domain.User;
import com.acme.usermanagement.presentation.form.ChangePasswordForm;

@RunWith(Parameterized.class)
public class ChangePasswordFormValidatorTest {
	
	private boolean hasErrors;
	
	private ChangePasswordForm form;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ anUser().withPassword("secret").build(), 	"secret", 		"my-new-password", 	"my-new-password", 	false },
			{ anUser().withPassword("secret").build(), 	"", 			"my-new-password", 	"my-new-password", 	true },
			{ anUser().withPassword("secret").build(), 	"secret", 		"", 				"my-new-password", 	true },
			{ anUser().withPassword("secret").build(), 	"secret", 		"my-new-password", 	"", 				true },
			{ anUser().withPassword("secret").build(), 	"nomatch", 		"my-new-password", 	"my-new-password", 	true },
			{ anUser().withPassword("secret").build(), 	"secret", 		"secret", 			"my-new-password", 	true },
			{ anUser().withPassword("secret").build(), 	"secret", 		"my-new-password", 	"nomatch", 			true },
			{ anUser().withPassword("secret").build(), 	"secret", 		"weak", 			"weak", 			true },
		});
	}
	
	public ChangePasswordFormValidatorTest(User currentUser, String currentPassword, String newPassword, String confirmNewPassword, boolean hasErrors) {
	      initChangePasswordForm(currentUser, currentPassword, newPassword, confirmNewPassword);
	      
	      this.hasErrors = hasErrors;
	}
	
	@Test
	public void test() {
		Errors errors = new BeanPropertyBindingResult(form, "target");
	       
	    new ChangePasswordFormValidator().validate(form, errors);
	       
	    assertEquals(hasErrors, errors.hasErrors()); 
	}

	private void initChangePasswordForm(User currentUser, String currentPassword, String newPassword, String confirmNewPassword) {
		this.form = new ChangePasswordForm();
		this.form.setCurrentUser(currentUser);
		this.form.setCurrentPassword(currentPassword);
		this.form.setNewPassword(newPassword);
		this.form.setConfirmNewPassword(confirmNewPassword);
	}
	
	//havingAValidUser
		//havingUserWithEmptyCurrentPassword
		//havingUserWithEmptyNewPassword
		
		//rejectWhenUserPasswordIsNotSameAsCurrentPassword
		//rejectWhenCurrentPasswordIsEmpty
	
}