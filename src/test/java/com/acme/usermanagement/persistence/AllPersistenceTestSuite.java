package com.acme.usermanagement.persistence;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
	UserRepositoryIntegrationTest.class
})
public class AllPersistenceTestSuite {}