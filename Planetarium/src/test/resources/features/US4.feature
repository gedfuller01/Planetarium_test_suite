@US4
Feature: Creating Planets
  As a user I want to add new planets and moons to the Planetarium so I can update my findings
  Background:
    Given the user is logged in on the home page

    Scenario Outline: Users should be able to add planets
      When the user gives data for a "<planet>"
      Then the table should refresh
      And a new planet should be visible on their home page

    Examples:
      |planet|
      |Glip_Glorb-1 1|
    Scenario Outline: Users should be able to add moons
      When the user gives data for a "<moon>"
      Then the table should refresh
      And a new moon should be visible on their home page

    Examples:
      |moon|
      |Glorb_Glip-2 2|

    Scenario Outline: Users should not be able to add invalid planets
      When the user gives data for a "<planet>"
      And the data is invalid
      Then the user should get an alert saying "Invalid Planet Name"

    Examples:
      |planet|
      |Earth|
      |aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|
      |RealPlanet2?                   |

    Scenario Outline: Users should not be able to add invalid moons
      When the user gives data for a "<moon>"
      And the data is invalid
      Then the user should get an alert saying "Invalid Moon Name"

    Examples:
      |moon|
      |Luna|
      |aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa|
      |RealMoon2?                     |
    Scenario Outline: Users should be able to add an image with a valid planet
      When the user gives data for a "<planet>"
      And the user provides an "<image>"
      Then the table should refresh
      And a new planet should be visible on their home page
    Examples:
      |planet|image|
      |Jupiter|jpg |
    Scenario Outline: Users should not be able to add an invalid image
      When the user gives data for a "<planet>"
      And the user provides an "<image>"
      And the data is invalid
      Then the user should get an alert saying "Invalid file type"

    Examples:
      |planet|image|
      |Saturn|pdf  |
