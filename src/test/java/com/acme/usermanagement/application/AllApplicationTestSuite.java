package com.acme.usermanagement.application;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UserManagementServiceTest.class
})
public class AllApplicationTestSuite {}