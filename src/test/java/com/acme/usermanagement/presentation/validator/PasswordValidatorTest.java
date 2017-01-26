package com.acme.usermanagement.presentation.validator;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import com.acme.usermanagement.domain.Password;

@RunWith(Parameterized.class)
public class PasswordValidatorTest {
	
	private String value;
	
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ "strong", false },
	        { "weak", 	true  },
	        { "", 		true  }
		});
	}
	
	public PasswordValidatorTest(String value, boolean expected) {
	      this.value = value;
	      this.expected = expected;
	}
	
	@Test
	public void test() {
		Password password = new Password(value);
	 
		Errors errors = new BeanPropertyBindingResult(password, "target");
	       
	    new PasswordValidator().validate(password, errors);
	       
	    assertEquals(expected, errors.hasErrors()); 
	}
	
}