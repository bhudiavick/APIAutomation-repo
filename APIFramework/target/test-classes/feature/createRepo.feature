Feature: Validate Create Repository

Scenario: 	Verify Create Repo API
	Given  	Starting TestCase "Verify Create Repo API"
	Given   Create Repo Payload
	When 	User calls Create API "/user/repos" POST API Call
	Then 	API Call is Successful with 201 status code
	And 	Verify Repository "name" is "API-TEST-REPO"
	And 	Verify Repository "description" is "API rep created via BDD Test"
	And 	Ending TestCase 
	
Scenario: 	Verify Delete Repo API
	Given 	Starting TestCase "Verify Delete Repo API"
	Given   Create Repo Payload
	When 	User calls Delete API "/repos/bhudiavick/" 
	Then 	API Call is Successful with 204 status code
	And 	Ending TestCase

	
		

	