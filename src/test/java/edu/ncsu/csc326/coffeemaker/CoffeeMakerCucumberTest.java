package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoffeeMakerCucumberTest {

    private CoffeeMaker coffeeMaker;
    private Recipe recipe;
    private int paidAmount;

    @Given("The Coffee Maker waits for user input.")
    public void theCoffeeMakerWaitsForUserInput() {
        coffeeMaker = new CoffeeMaker();
        recipe = new Recipe();
    }

    @When("I want to purchase beverage cost {int}")
    public void iWantToPurchaseBeverageCost(int amount) throws RecipeException {
        recipe.setPrice(String.valueOf(amount));
        assertTrue(coffeeMaker.addRecipe(recipe));
    }

    @And("I give coffee maker {int}")
    public void iGiveCoffeeMaker(int amount) {
        paidAmount = amount;
    }

    @Then("I get money back {int}")
    public void iGetMoneyBack(int amount) {
        int beverageCost = coffeeMaker.getRecipes()[0].getPrice();
        if (paidAmount < beverageCost) {
            assertEquals(paidAmount, coffeeMaker.makeCoffee(0, paidAmount));
        } else {
            int change = paidAmount - beverageCost;
            assertEquals(change, coffeeMaker.makeCoffee(0, paidAmount));
        }
    }
}
