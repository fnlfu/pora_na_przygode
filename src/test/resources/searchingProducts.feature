Feature: Searching products

  As a user
  I want find specific product in store

  Scenario Outline: User searching specific product in store
    Given I am on home page
    When I search item "<item>"
    Then I see specific product "<productName>" on search result
    When I open item "<productName>"
    Then I have found item "<productName>"
    Examples:
      | item                                    | productName                      |
      | Garmin Sportwatch Fenix 5 Plus Sapphire | Sportwatch Fenix 5 Plus Sapphire |
      | COLEMAN Tent                            | Tent Oak Canyon 4                |
