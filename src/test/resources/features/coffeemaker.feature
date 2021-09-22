Feature: Purchase beverages
  The user selects a beverage and inserts an amount of money. The money must be an integer.
  If the beverage is in the RecipeBook and the user paid enough money the beverage will be dispensed
  and any change will be returned. The user will not be able to purchase a beverage
  if they do not deposit enough money into the CoffeeMaker.
  A user's money will be returned if there is not enough inventory to make the beverage.
  Upon completion, the Coffee Maker displays a message about the purchase status and is returned to the main menu.

  Background:
    Given The Coffee Maker waits for user input.
    Given The Coffee Maker has 3 valid recipes.

  Scenario: Purchase beverage with enough money
    When I want to purchase beverage number 1
    And I give coffee maker 50
    Then I get money back 0

  Scenario: Purchase beverage with not enough money
    When I want to purchase beverage number 1
    And I give coffee maker 30
    Then I get money back 50

  Scenario: Purchase beverage with exceed money
    When I want to purchase beverage number 1
    And I give coffee maker 60
    Then I get money back 10

  Scenario: Purchase beverage that not enough ingredients
    When I want to purchase beverage number 1
    And I give coffee maker 50
    Then I get money back 0
