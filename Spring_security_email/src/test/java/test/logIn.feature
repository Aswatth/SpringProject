#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@LOGIN
Feature: Login
  Scenario Outline: Check Login
	  Given I am in home page
  	When I click login
  	Then I should see login "http://localhost:8080/login"
  	Given I am in login page
  	When I enter <mailID> and <password>
  	Then I should see "http://localhost:8080/home"
  	When I click logout
  	Then I should see login "http://localhost:8080/login"
		
		Examples:
			|mailID						   |password|
			|"aswatth@myMail.com"|"1234"	|
			|"abcd@myMail.com"	 |"1234"	|
			|"none@myMail.com"	 |"1234"	|
