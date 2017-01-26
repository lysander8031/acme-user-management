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
import org.springframework.validation.Validator;

import com.acme.usermanagement.domain.User;

@RunWith(Parameterized.class)
public class UserValidatorTest {
	
	private User user;
	
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ aValidUser(), 				false },
	        { anUserWithNoFirstName(), 		true  },
	        { anUserWithNoLastName(), 		true  },
	        { anUserWithNoStreet(), 		true  },
	        { anUserWithNoCity(), 			true  },
	        { anUserWithNoEmail(), 			true  },
	        { anUserWithInvalidEmail(), 	true  },
	        { anUserWithNoPassword(), 		true  },
	        { anUserWithWeakPassword(), 	true  }
		});
	}
	
	public UserValidatorTest(User user, boolean expected) {
	      this.user = user;
	      this.expected = expected;
	}
	
	@Test
	public void test() {
		Errors errors = new BeanPropertyBindingResult(user, "target");
	       
		userValidator().validate(user, errors);
	       
	    assertEquals(expected, errors.hasErrors()); 
	}
	
	private Validator userValidator() {
		return new UserValidator(
				new AddressValidator(), new EmailValidator(), 
				new NameValidator(), new PasswordValidator());
	}
	
	private static User aValidUser() {
		return anUser().build();
	}
	
	private static User anUserWithNoFirstName() {
		return anUser().withNoFirstName().build();
	}
	
	private static User anUserWithNoLastName() {
		return anUser().withNoLastName().build();
	}
	
	private static User anUserWithNoStreet() {
		return anUser().withNoStreet().build();
	}
	
	private static User anUserWithNoCity() {
		return anUser().withNoCity().build();
	}
	
	private static User anUserWithNoEmail() {
		return anUser().withNoEmail().build();
	}
	
	private static User anUserWithInvalidEmail() {
		return anUser().withInvalidEmail().build();
	}
	
	private static User anUserWithNoPassword() {
		return anUser().withNoPassword().build();
	}
	
	private static User anUserWithWeakPassword() {
		return anUser().withWeakPassword().build();
	}
	
}