Feature: Purchase beverages

  Background:
    Given The Coffee Maker waits for user input.

  Scenario: Purchase beverage with enough money
    When I want to purchase beverage number 1 that cost 50
    And I give coffee maker 50
    Then I get money back 0

  Scenario: Purchase beverage with not enough money
    When I want to purchase beverage number 1 that cost 50
    And I give coffee maker 30
    Then I get money back 50

  Scenario: Purchase beverage with exceed money
    When I want to purchase beverage number 1 that cost 50
    And I give coffee maker 60
    Then I get money back 10

  Scenario: Purchase beverage that not enough ingredients
    When I want to purchase beverage number 1 that cost 50
    And I give coffee maker 50
    Then I get money back 0

  Scenario: Purchase beverage that not in menu
    When I want to purchase beverage number 4 that cost 100
    And I give coffee maker 100
    Then I give coffee maker 100