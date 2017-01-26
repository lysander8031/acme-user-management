package com.acme.usermanagement.domain;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	AddressTest.class,
	CredentialTest.class,
	EmailTest.class,
	NameTest.class,
	PasswordTest.class,
	UserTest.class,
	UserServiceTest.class
})
public class AllDomainTestSuite {}