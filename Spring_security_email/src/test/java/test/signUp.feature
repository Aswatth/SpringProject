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
@SIGN_UP
Feature: SignUp
  Scenario Outline: Check signUp
	  Given I am in home page
  	When I click signUp
  	Then I should see signUp "http://localhost:8080/signup" 
  	And I enter <NAME> <MAIL_ID> <PASSWORD>
  	Given I am in login page
  	When I enter <MAIL_ID> and <PASSWORD>
  	Then I should see "http://localhost:8080/home"
  	
  	Examples:
			|NAME				|MAIL_ID						 |PASSWORD|
			|"Someone_1"|"someone@myMail.com"|"1234"	|
			|"Someone_2"|"someone@myMail.com"|"0000"	|
 