Feature: Currency Selection

  Scenario: Verify Euro Symbol (€) Appears for All Products
    Given the user is at the homepage
    When the user selects "Euro" from the currency dropdown
    Then all product prices should display the "€" symbol