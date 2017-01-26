package com.acme.usermanagement.acceptance;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		glue = {"com.acme.usermanagement.acceptance", "cucumber.api.spring"},
		features="classpath:features", 
		snippets=SnippetType.CAMELCASE)
public class AllAcceptanceTestSuite {}