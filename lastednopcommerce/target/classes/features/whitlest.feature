Feature: Wishlist Functionality

  Scenario: Add HTC One M8 product to wishlist and verify success message
    Given the user is on the homepage
   When the user click add "HTC One M8 Android L 5.0 Lollipop" to the wishlist
    And the user clicks the "Add to wishlist" button
    Then a green success message "The product has been added to your wishlist" should appear