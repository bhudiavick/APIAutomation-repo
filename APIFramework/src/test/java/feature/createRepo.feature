Feature: Validate Create Repository



Scenario Outline: 	Verify Create Repo API
	Given  	Starting TestCase "Verify Create Repo API"
	Given   Create Repo Payload name "<name>" and description "<description>"
	When 	User calls Create API "/user/repos" POST API Call
	Then 	API Call is Successful with 201 status code
	And 	Verify Repository "name" is "<name>"
	And 	Verify Repository "description" is "<description>"
	And 	Ending TestCase 

Examples:
	|	name	|	description		|
	|	repo1	|	DDT repo1		|
	|	repo2	|	DDT repo2		|
	|	repo3	|	DDT repo3		|

	
Scenario Outline: 	Verify Delete Repo API
	Given 	Starting TestCase "Verify Delete Repo API"
	Given   Create Repo Payload name "<name>" and description "<description>"
	When 	User calls Delete API "/repos/bhudiavick/" 
	Then 	API Call is Successful with 204 status code
	And 	Ending TestCase

Examples:
	|	name	|	description		|
	|	repo1	|	DDT repo1		|
	|	repo2	|	DDT repo2		|
	|	repo3	|	DDT repo3		|
	
		

	
