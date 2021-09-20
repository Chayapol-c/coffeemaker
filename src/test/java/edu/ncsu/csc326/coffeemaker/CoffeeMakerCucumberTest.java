package edu.ncsu.csc326.coffeemaker;

import static org.junit.Assert.*;

import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CoffeeMakerCucumberTest {

    private CoffeeMaker coffeeMaker;
    private int paidAmount;
    private int recipeNumber;

    /**
     * Return a valid Recipe object
     *
     * @param name
     * @param chocolate
     * @param coffee
     * @param milk
     * @param sugar
     * @param price
     * @throws RecipeException if there was an error parsing the ingredient
     *                         amount when setting up the recipe.
     */
    private Recipe createRecipe(String name, String chocolate, String coffee, String milk, String sugar, String price) throws RecipeException {
        Recipe newRecipe = new Recipe();
        newRecipe.setName(name);
        newRecipe.setAmtChocolate(chocolate);
        newRecipe.setAmtCoffee(coffee);
        newRecipe.setAmtMilk(milk);
        newRecipe.setAmtSugar(sugar);
        newRecipe.setPrice(price);
        return newRecipe;
    }

    @Given("The Coffee Maker waits for user input.")
    public void theCoffeeMakerWaitsForUserInput() throws RecipeException {
        coffeeMaker = new CoffeeMaker();
        coffeeMaker.addRecipe(createRecipe("Coffee", "0", "3", "1", "1", "50"));
        coffeeMaker.addRecipe(createRecipe("Mocha", "20", "3", "1", "1", "75"));
        coffeeMaker.addRecipe(createRecipe("Latte", "0", "3", "3", "1", "100"));
    }

    @When("I want to purchase beverage number {int} that cost {int}")
    public void iWantToPurchaseBeverageNumberThatCost(int number, int amount) {
        if (number < 4){
            recipeNumber = number - 1;
        }
    }

    @And("I give coffee maker {int}")
    public void iGiveCoffeeMaker(int amount) {
        paidAmount = amount;
    }

    @Then("I get money back {int}")
    public void iGetMoneyBack(int amount) {
        int beverageCost = coffeeMaker.getRecipes()[recipeNumber].getPrice();
        if (paidAmount < beverageCost) {
            assertEquals(paidAmount, coffeeMaker.makeCoffee(recipeNumber, paidAmount));
        } else {
            assertEquals(amount, coffeeMaker.makeCoffee(recipeNumber, paidAmount));
        }


    }


}
