Feature: Click on Next button without entering UserName
		 

Scenario Outline: Click on Next button without entering username 
					throws an error message

Given I goto "loginURL" on "<Browser>"
And I click "signInLink" Link
And I click on "nextButton"                     
Then I see "emailErrorMessage" as "expected_Result"

|Browser| Expected_Result|
|Mozilla|Please enter your email.|
|IE     |Please enter your email.|





