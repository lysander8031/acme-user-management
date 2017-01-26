@txn
Feature: Change user password

#Scenario: Change password
#	Given I am a registered user
#	When I submit valid change password details
#	Then my password should be changed
	
Scenario: Change password successfully
	Given I am a registered user
	When I change my password to "secret"
	Then my new password should be "secret"