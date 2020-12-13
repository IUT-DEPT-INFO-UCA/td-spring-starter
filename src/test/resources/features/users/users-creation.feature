@txn
Feature: Create a new user



Scenario: Create the first user
	Given there is no user created
	When we try to create a user with firstname 'Jon' and lastname 'Snow'
	Then we have this response
	| id | firstname | lastname |
	| 1 | Jon | Snow |
   # And we have only 1 user in DB
