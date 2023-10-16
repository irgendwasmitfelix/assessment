@test
Feature: Lowest price product Checkout tests
  As a new Amazon user, I want to search for the cheapest Snickers and Skittles on the page

  Scenario: Check Checkout flow
    Given I am on the "https://amazon.com" page

    When I set delivery location to zipcode "44114"

    When I search for "Snickers"
    Then Verify that result for "Snickers" is displayed
    When I apply sorting as "Price: Low to High"
    Then I get first lowest price product
    When I click on first lowest price product
    Then Verify that product detail page is displayed
    When I click on Add to Cart
    Then Verify that header cart count increased to "1"

    When I search for "Skittles"
    Then Verify that result for "Skittles" is displayed
    When I apply sorting as "Price: Low to High"
    Then I get first lowest price product
    When I click on first lowest price product
    Then Verify that product detail page is displayed
    When I click on Add to Cart
    Then Verify that header cart count increased to "2"

    When I click on cart icon from header
    Then Verify that cart page is displayed with "2 items"
    Then Verify that product wise total price calculated
    When I click on checkout button
    Then Verify that Sign In page is displayed

