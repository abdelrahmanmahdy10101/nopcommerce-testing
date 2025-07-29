Feature: User Registration

  Scenario: Valid Register
    Given User is on the NopCommerce homepage
    When User navigates to the Register page
    And User selects gender "male"
    And User enters first name "automation" and last name "tester"
    And User enters Date of Birth "1", "January", "1990"
    And User enters email "abdelrahmanmahdy5255@gmail.com"
    And User enters password "Admin@12345" and confirms it
    And User clicks the Register button
    Then A success message should be displayed
    And The message text should be "Your registration completed"
    And The message color should be "rgba(76, 177, 124, 1)"