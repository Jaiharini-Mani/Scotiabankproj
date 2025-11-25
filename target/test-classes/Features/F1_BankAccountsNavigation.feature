# Author: Jaiharini_Mani
# Date: Nov 06,2025
Feature: As a customer
  		I want to view and access various Bank Account options from the main menu
  		So that I can easily explore different account types and open a new account

  Background: Launch Scotiabank homepage
    Given user is on the Scotiabank Personal Banking home page
    And Scotiabank logo is displayed

  Scenario: Verify submenu item displayed under Bank Accounts
    When user hovers mouse over the "Bank Accounts" menu option
    And user clicks on "Chequing accounts" from the dropdown
    Then user should be navigated to the Chequing Accounts page with title containing "Discover Scotia's chequing accounts"

  Scenario: Apply as a new customer and reach eligibility message
    When user hovers mouse over the "Bank Accounts" menu option
    And user clicks on "Chequing accounts" from the dropdown
    And user clicks "Open an account" on the "Ultimate Package"
    And user selects "No" on the application question
    Then "Apply as a new customer" button should be displayed
    When user clicks on "Apply as a new customer"
    Then the page header should contain "Are you a Canadian citizen?"
    When user selects "No" on the citizenship question
    And user selects immigration status "Other"
    And user clicks "Continue"
    Then the message "Sorry, we can’t complete your request online" should be displayed
