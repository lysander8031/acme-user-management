package com.acme.usermanagement;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.acme.usermanagement.acceptance.AllAcceptanceTestSuite;
import com.acme.usermanagement.persistence.AllPersistenceTestSuite;

@RunWith(Suite.class)
@SuiteClasses({
	AllAcceptanceTestSuite.class,
	AllPersistenceTestSuite.class
})
public class AllIntegrationTestSuite { }