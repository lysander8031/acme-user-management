package com.acme.usermanagement.presentation.validator;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.acme.usermanagement.domain.Email;

@RunWith(Parameterized.class)
public class EmailValidatorTest  {
	
	private String value;
	
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ "abc@example.com", 	false },
	        { "no@domain", 			true  },
	        { "", 					true  }
		});
	}
	
	public EmailValidatorTest(String value, boolean expected) {
	      this.value = value;
	      this.expected = expected;
	}
	
	@Test
	public void test() {
		Email email = new Email(value);
	 
		Errors errors = new BeanPropertyBindingResult(email, "target");
	       
	    new EmailValidator().validate(email, errors);
	       
	    assertEquals(expected, errors.hasErrors()); 
	}
	
}