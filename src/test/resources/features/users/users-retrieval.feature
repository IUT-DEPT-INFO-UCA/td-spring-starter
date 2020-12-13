Feature: find users



Scenario: Get all users
	Given these existing users
	| id | firstname | lastname |
	| 1 | Khal | Drogo |
	| 2 | Sansa | Stark |
	| 3 | Jon | Snow |
	| 4 | Tyrion | Lannister |
	| 5 | Arya | Stark |
	When we try to retrieve all users
	Then we have this response
	| id | firstname | lastname |
	| 1 | Khal | Drogo |
	| 2 | Sansa | Stark |
	| 3 | Jon | Snow |
	| 4 | Tyrion | Lannister |
	| 5 | Arya | Stark |
	

Scenario: find users by names
	Given these existing users
	| id | firstname | lastname |
	| 1 | Khal | Drogo |
	| 2 | Sansa | Stark |
	| 3 | Jon | Snow |
	| 4 | Tyrion | Lannister |
	| 5 | Sansa | Stark |
	When we search users with firstname 'Sansa' and lastname 'Stark'
	Then we have this response
	| id | firstname | lastname |
	| 2 | Sansa | Stark |
	| 5 | Sansa | Stark |