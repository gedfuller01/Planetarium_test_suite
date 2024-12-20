@US2 @SR1 @SR3
  Feature: Logging in
    As a user I want to securely access my account so I can interact with the Planetarium in a secure environment

    Background: Registration Starting Actions
      Given   the user is on the login page

      Scenario Outline: Users can login with valid credentials
        When the user provides username "<username>"
        When the user provides password "<password>"
        Then  the user should login successfully
        And be brought to the home page

        Examples:
        |username|password|
        |Batman|Iamthenight1939|
      Scenario Outline: Users cannot login with invalid credentials
        When the user provides username "<username>"
        When the user provides password "<password>"
        Then the user should get an invalid credentials alert
        And should remain on the login page

        Examples:
        |username|password|
        |Batman  |b0Ts    |
        |Robin   |Iamthenight1939|
        |Robin   |b0Ts           |

