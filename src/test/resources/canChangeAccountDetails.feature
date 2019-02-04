Feature: Changing account details

  As a user
  I want to be able to change my account details (e.g. phone number)

  Scenario Outline: User logs in, goes to profile details and changes phone number
    Given I am on home page
    When I login as "<username>" using "<password>"
    Then I can access Profile Details page
    When I update Phone number
    Then changes are saved
    When I logout
    Then I'm not logged in

    Examples:
      | username                   | password        |
      | test.user21@mailinator.com | DSNYktEjpD9MTMA |
