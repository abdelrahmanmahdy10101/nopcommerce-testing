Feature: Wishlist Functionality

  Scenario: Validate item appears in the wishlist
    Given the user is on the HTC smartphone product page
    When the user adds the item to the wishlist again
    And the success message disappears
    And the user clicks on the Wishlist tab
    And the user goes to the wishlist page
    Then the item quantity in the Wishlist should be greater than 0