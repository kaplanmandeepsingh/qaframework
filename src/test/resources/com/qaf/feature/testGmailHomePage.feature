Feature: Gmail Home Page
		Launching gmail.com should not automatically login an user

Scenario Outline: Launch Gmail.com

Given I goto "loginURL" on "<Browser>"
Then I see "signMessage" as "<Sign in>"

Examples:
|Browser| Expected_Result|
|Mozilla|Sign in|
|IE     |Sign in|

