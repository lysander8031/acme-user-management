package com.acme.usermanagement;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.usermanagement.application.AllApplicationTestSuite;
import com.acme.usermanagement.domain.AllDomainTestSuite;
import com.acme.usermanagement.presentation.validator.AllValidatorTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AllDomainTestSuite.class,
	AllApplicationTestSuite.class,
	AllValidatorTestSuite.class
})
public class AllUnitTestSuite { }