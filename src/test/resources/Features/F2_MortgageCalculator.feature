Feature: As a user
  I want to use the Mortgage Calculator on Scotiabank website
  So that I can estimate my monthly payments before applying for a mortgage

  Background:
    Given user is on the Scotiabank Personal Banking home page
    And Scotiabank logo is displayed

  Scenario: Navigation
    When user hovers mouse over the "Mortgages" menu option
    And user clicks on "Mortgage calculator" from the dropdown
    Then user should be navigated to the Mortgage Calculator page
    And the page title should contain "Mortgage Calculator"

  Scenario: Mortgage payment calculation
    Given user is on Mortgage page
    And user selects payment frequency
    And user selects type of mortgage
    Then the monthly payment displayed should be correct
