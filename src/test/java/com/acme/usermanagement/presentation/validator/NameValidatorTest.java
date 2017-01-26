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

import com.acme.usermanagement.domain.Name;

@RunWith(Parameterized.class)
public class NameValidatorTest {
	
	private String firstName;
	
	private String lastName;
	
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ "David", 	"Kalinov", 	false },
	        { "David", 	"", 		true  },
	        { "", 		"Kalinov", 	true  }
		});
	}
	
	public NameValidatorTest(String firstName, String lastName, boolean expected) {
	      this.firstName = firstName;
	      this.lastName = lastName;
	      this.expected = expected;
	}
	
	@Test
	public void test() {
		Name name = new Name(firstName, lastName);
	 
		Errors errors = new BeanPropertyBindingResult(name, "target");
	       
	    new NameValidator().validate(name, errors);
	       
	    assertEquals(expected, errors.hasErrors()); 
	}

}