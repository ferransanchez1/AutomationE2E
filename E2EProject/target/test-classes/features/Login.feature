Feature: Login into Application

Scenario Outline: Positive test validation login
Given Initalize the browser with chrome
And Navigate to "http://qaclickacademy.com" Site
And Click on Login link in home page to land in secure sign in Page
When Users enter <username> and <password> and logs in
Then Verify that user is succesfully logged in
And Close all browsers


Examples:
|username			|password		|
|test99@gmail.com	|123456			|
|test123@gmail.com	|12345			|
