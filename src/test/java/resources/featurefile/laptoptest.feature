Feature: Add to cart functionality check

  Background: User is on amazon homepage
    Given User is on amazon homepage

@Sanity @Regression
    Scenario: User should be able to add laptop to the cart successfully
      When User search for "Laptop" in the search bar
      And User clicks on the search button
      And User finds and clicks on the selection "Lenovo IdeaPad 3 15 Intel i3-10110U 8GB 256GB SSD 15.6-inch Touch Screen Laptop"
      And selects the quantity "3"
      And clicks on the add to cart button
      Then User is able to verify "Added to Cart" message