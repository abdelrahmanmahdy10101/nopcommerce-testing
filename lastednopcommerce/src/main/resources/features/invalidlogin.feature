Feature: Login Functionality

  Scenario: Invalid Login
    Given the user goes to the Login page
    When the user enters invalid email "wrong@example.com" and password "P@ssw0rd"
    And the user click the Login buttom
    Then the user should see an error message containing "Login was unsuccessful."
    And the error message color should be "#e4434b"