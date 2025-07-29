Feature: User Login

  Scenario: Valid Login
    Given the user navigates to the login page
    When the user enters a valid email "abdelrahmanmahdy655@gmail.com" and password "Admin@12345"
    And the user clicks the login button
    Then the current URL should be "https://demo.nopcommerce.com/"
    And the "MY ACCOUNT" tab should be displayed

