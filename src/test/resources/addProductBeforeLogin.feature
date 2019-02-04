Feature: The product added before login remains in basket.

  As a user
  I want the product added to basket to remain after I logged in

  Scenario Outline: User finds the product, adds it to basket, navigates to checkout, logs in, checks if the product is still in basket,
    removes the product from basket, checks that the basket empty

    Given I am on home page
    When I search item "<item>"
    Then I see specific product "<productName>" on search result
    When I open item "<productName>"
    Then I have found item "<productName>"

    When I add the product to basket
    And I navigate to basket
    Then I'm on basket page
    And "<productName>" appears in basket

    When I checkout
    Then I'm directed to checkout welcome page

    When I login at checkout welcome page as "<username>" using "<password>"
    Then I'm directed to Buy steps page

    When I continue shopping
    And I navigate to basket
    Then "<productName>" appears in basket

    When I remove "<productName>" from basket
    Then "<productName>" no longer present in basket
    And the basket is empty

    When I logout
    Then I'm not logged in

    Examples:
      | username                   | password        |item                                    | productName                      |
      | test.user21@mailinator.com | DSNYktEjpD9MTMA |Garmin Sportwatch Fenix 5 Plus Sapphire | Sportwatch Fenix 5 Plus Sapphire |
