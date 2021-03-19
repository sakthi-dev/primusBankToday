Feature: Credit Feature

Background: User is successfully logged in
When user opens "Linux" OperatingSystem and user opens "Chrome" browser
When user enters the url "http://primusbank.qedgetech.com/"
	
@SmokeTest
Scenario: Login Functionality for valid username and password
When user enters "Admin" as username
When user enters "Admin" as password
Then user is on the "Admin" main page and get message as welcome to Admin
Then credit login scenario is successfull
Then Login is fail
	
	
	
	
	
