@US5 @SR2
  Feature: Deleting planets and moons
    As a user I want to remove planets and moons from the Planetarium so I can correct my findings
  Background:
    Given the user is logged in on the home page

  Scenario Outline: deleting planets
    When the user gives data "<planet>" for the planet they wish to delete
    And the planet exists
    Then the table should refresh with the planet deleted
    And all moons related to the planet should be deleted as well

    Examples:
    |planet|
    |Mars  |

  Scenario Outline: incorrect planet name
    When the user gives data "<planet>" for the planet they wish to delete
    And the planet doesn't exist
    Then the user should get an alert saying Invalid planet name

    Examples:
    |planet|
    |Not a real planet|

  Scenario Outline: deleting moons
    When the user gives data "<moon>" for the moon they wish to delete
    And the moon exists
    Then the table should refresh with the moon deleted

    Examples:
    |moon|
    |Luna|

  Scenario Outline: incorrect moon name
    When the user gives data "<moon>" for the moon they wish to delete
    And the moon doesn't exist
    Then the user should get an alert saying Invalid moon name

    Examples:
    |moon|
    |Not a real moon|
