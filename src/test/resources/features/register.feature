@txn
Feature: Register with regular account

#Scenario: Register a new user
#	Given I am not a registered user
#	When I submit valid registration details
#	Then I should be registered
	
Scenario: Register a new user
	Given I am not a registered user
	When I register
	Then I should be a registered user
	
Scenario: Register an existing user
	Given I am an already registered user
	When I register
	Then I should not be allowed to register