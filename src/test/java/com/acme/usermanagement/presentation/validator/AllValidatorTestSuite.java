package com.acme.usermanagement.presentation.validator;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AddressValidatorTest.class,
	ChangePasswordFormValidatorTest.class,
	EmailValidatorTest.class,
	NameValidatorTest.class,
	PasswordValidatorTest.class,
	UserValidatorTest.class
})
public class AllValidatorTestSuite {}