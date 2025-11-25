# Author: Jaiharini_Mani
# Date: Nov 07, 2025
Feature: As a Scotiabank user
  I want to sign in securely
  So that I can access my personal banking account

  Background:
    Given user is on the Scotiabank Personal Banking home page
    And Scotiabank logo is displayed

  
  Scenario: User navigates to the Sign-In page
    When user clicks on "Sign In" button
    Then user should be navigated to the Sign-In page with title containing "Welcome to"


  Scenario Outline: Sign-In validation error messages
    When user clicks on "Sign In" button
    And user enters username "<username>"
    And user enters password "<password>"
    And user clicks on Sign-In button

    Examples:
      | username    | password    |                                                      
      |             | test@123    | 
      | wrongUser   |             | 
      | invalidUser | invalidPass |
