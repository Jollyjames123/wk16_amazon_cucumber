Feature: Add to cart functionality check

  Background: User is on amazon homepage
    Given User is on amazon homepage

  @Smoke @Regression
  Scenario: User should be able to add mobile phone to the cart successfully
    When User search for "Mobile Phone" in the search bar
    And User clicks on the search button
    And User finds and clicks on the selection "Nokia XR20 5G | Android 11 | Unlocked Smartphone | Dual SIM | US Version | 6/128GB | 6.67-Inch Screen | 48MP Dual Camera | Polar Night"
    And selects the quantity "2"
    And clicks on the add to cart button
    Then User is able to verify "Added to Cart" message