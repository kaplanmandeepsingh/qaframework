Feature: Login to Gmail 
		 Login to Gmail and check if loggin is successful 
		 verifying sign in message

Scenario Outline: Login to Gmail using correct Username/Password

Given I goto "loginURL" on "<Browser>"
And I click "signInLink" Link
And Enter "loginUserName" as "<UserName>"
And I click on "nextButton"                     
And Enter "loginPassword" as "<Password>"                     
And I click on "signInButton"
Then I see success "signMessage" as "<Expected_Result>"

Examples:
|Browser| Username				 | Password |Expected_Result|
|Mozilla|kaplantesters@gmail.com>|Kaplan2015|Google Account: kaplantesters@gmail.com|
|IE     |kaplantesters@gmail.com>|Kaplan2015|Google Account: kaplantesters@gmail.com|
