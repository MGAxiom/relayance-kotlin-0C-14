Feature: Add New Customer

  As a user
  I want to be able to add a new customer
  So that I can keep track of my clients

  Scenario: Add a new customer successfully
    Given I am on the main customer list screen
    When I tap the add customer button
    And I enter "New Customer Name" in the name field
    And I enter "new.customer@email.com" in the email field
    And I tap the save button
    Then I should see the main customer list screen
    And I should see "New Customer Name" in the list
