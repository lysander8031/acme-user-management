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

import com.acme.usermanagement.domain.Address;

@RunWith(Parameterized.class)
public class AddressValidatorTest {
	
	private String street;
	
	private String city;
	
	private String state;
	
	private String zip;
	
	private boolean expected;
	
	@Parameters
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][] {
			{ "111 Market Str", 	"Chicago", 		"IL", 	"94105", 	false },
			{ "", 					"Chicago", 		"IL", 	"94105", 	true },
			{ "111 Market Str", 	"", 			"IL", 	"94105", 	true },
		});
	}
	
	public AddressValidatorTest(String street, String city, String state, String zip, boolean expected) {
	      this.street = street;
	      this.city = city;
	      this.state = state;
	      this.zip = zip;
	      this.expected = expected;
	}
	
	@Test
	public void test() {
		Address address = new Address(street, city, state, zip);
	 
		Errors errors = new BeanPropertyBindingResult(address, "target");
	       
	    new AddressValidator().validate(address, errors);
	       
	    assertEquals(expected, errors.hasErrors()); 
	}
	
}