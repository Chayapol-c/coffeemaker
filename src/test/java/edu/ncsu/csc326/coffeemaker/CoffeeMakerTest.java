/*
 * Copyright (c) 2009,  Sarah Heckman, Laurie Williams, Dright Ho
 * All Rights Reserved.
 *
 * Permission has been explicitly granted to the University of Minnesota
 * Software Engineering Center to use and distribute this source for
 * educational purposes, including delivering online education through
 * Coursera or other entities.
 *
 * No warranty is given regarding this software, including warranties as
 * to the correctness or completeness of this software, including
 * fitness for purpose.
 *
 *
 * Modifications
 * 20171114 - Ian De Silva - Updated to comply with JUnit 4 and to adhere to
 * 							 coding standards.  Added test documentation.
 */
package edu.ncsu.csc326.coffeemaker;

import org.junit.Before;
import org.junit.Test;

import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;
<<<<<<< Updated upstream
import org.mockito.Mock;
=======
>>>>>>> Stashed changes
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Unit tests for CoffeeMaker class.
 *
 * @author Chayapol Chaipongsawalee 6210545947
 */
public class CoffeeMakerTest {

    /**
     * The object under test.
     */
    private CoffeeMaker coffeeMaker;
    private CoffeeMaker coffeeMakerMock;
<<<<<<< Updated upstream
    // Sample recipes to use in testing.
=======
>>>>>>> Stashed changes
    private Recipe recipe1;
    private Recipe recipe2;
    private Recipe recipe3;
    private Recipe recipe4;
    private Recipe recipe5;
<<<<<<< Updated upstream
    private Inventory inventory;
    private RecipeBook recipeBook;
    private Recipe[] recipes;
=======
    private RecipeBook recipeBook;
    private Recipe[] recipes;

>>>>>>> Stashed changes
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

    /**
     * Initializes some recipes to test with and the {@link CoffeeMaker}
     * object we wish to test.
     *
     * @throws RecipeException if there was an error parsing the ingredient
     *                         amount when setting up the recipe.
     */
    @Before
    public void setUp() throws RecipeException {
        coffeeMaker = new CoffeeMaker();
        recipeBook = Mockito.mock(RecipeBook.class);
<<<<<<< Updated upstream
        inventory = new Inventory();
=======
        Inventory inventory = new Inventory();
>>>>>>> Stashed changes
        coffeeMakerMock = new CoffeeMaker(recipeBook, inventory);

        recipe1 = createRecipe("Coffee", "0", "3", "1", "1", "50");
        recipe2 = createRecipe("Mocha", "20", "3", "1", "1", "75");
        recipe3 = createRecipe("Latte", "0", "3", "3", "1", "100");
        recipe4 = createRecipe("Hot Chocolate", "4", "0", "1", "1", "65");
        recipe5 = createRecipe("Lot of Ingredients", "0", "0", "0", "0", "50");

<<<<<<< Updated upstream
        recipes = new Recipe[] {recipe1, recipe2, recipe3};
=======
        recipes = new Recipe[]{recipe1, recipe2, recipe3};
>>>>>>> Stashed changes
    }

    /**
     * Given a coffee maker with 4 valid recipes
     * When the forth recipes
     * Then it can't be added.
     */
    @Test
    public void testAddMoreThanThree() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(recipe1.getName(), coffeeMaker.getRecipes()[0].getName());
        assertTrue(coffeeMaker.addRecipe(recipe2));
        assertEquals(recipe2.getName(), coffeeMaker.getRecipes()[1].getName());
        assertTrue(coffeeMaker.addRecipe(recipe3));
        assertEquals(recipe3.getName(), coffeeMaker.getRecipes()[2].getName());
        assertFalse(coffeeMaker.addRecipe(recipe4));
        assertEquals(recipe4.getName(), coffeeMaker.getRecipes()[3].getName());
    }

    /**
     * Given a coffee maker with a valid recipe
     * When add the same recipe
     * Then it can't be added.
     */
    @Test
    public void testAddDuplicate() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertFalse(coffeeMaker.addRecipe(recipe1));
    }

    /**
     * Given a coffee maker with a valid recipe
     * When we try to delete it
     * Then we get the name of deleted recipe.
     */
    @Test
    public void testDeleteRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(recipe1.getName(), coffeeMaker.deleteRecipe(0));
        assertNull(coffeeMaker.getRecipes()[0]);
    }

    /**
     * Given a coffee maker with one valid recipe
     * When we try to edit one recipe with different recipe
     * Then we get a name of a new recipe.
     */
    @Test
    public void testEditRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(recipe1.getName(), coffeeMaker.editRecipe(0, recipe2));
        Recipe replacedRecipe = coffeeMaker.getRecipes()[0];
        assertEquals(recipe2.getName(), replacedRecipe.getName());
        assertEquals(recipe2.getAmtCoffee(), replacedRecipe.getAmtCoffee());
        assertEquals(recipe2.getAmtChocolate(), replacedRecipe.getAmtChocolate());
        assertEquals(recipe2.getAmtMilk(), replacedRecipe.getAmtMilk());
        assertEquals(recipe2.getAmtSugar(), replacedRecipe.getAmtSugar());
        assertEquals(recipe2.getPrice(), replacedRecipe.getPrice());
    }

    /**
     * Given a coffee maker with one valid recipe
     * When we try to edit one recipe with there are no recipe
     * Then we get null.
     */
    @Test
    public void testEditEmptyRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertNotNull(coffeeMaker.editRecipe(0, recipe2));
        assertNull(coffeeMaker.editRecipe(1, recipe2));
        assertNull(coffeeMaker.editRecipe(2, recipe2));
        assertNull(coffeeMaker.editRecipe(3, recipe2));
    }

    /**
     * Given a coffee maker with the default inventory
     * When we add inventory with well-formed quantities
     * Then we do not get an exception trying to read the inventory quantities.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test
    public void testAddInventory() throws InventoryException {
        coffeeMaker.addInventory("4", "7", "0", "9");
        coffeeMaker.addInventory("1", "2", "3", "4");
        coffeeMaker.addInventory("123", "456", "789", "0");
        coffeeMaker.addInventory("10", "10", "10", "10");
    }

    /**
     * Given a coffee maker with the default inventory
     * When we add inventory with malformed quantities (i.e., a negative
     * quantity and a non-numeric string)
     * Then we get an inventory exception.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddInventoryException() throws InventoryException {
        coffeeMaker.addInventory("4", "-1", "asdf", "3");
        coffeeMaker.addInventory("abcd", "efgh", "ijkl", "mnop");
        coffeeMaker.addInventory("-4", "-3", "-2", "-1");
    }

    /**
     * Given a coffee maker with the default inventory
     * When we add inventory with same quantities
     * Then we do not get an exception trying to read the inventory quantities.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test
    public void testCheckInventory() throws InventoryException {
        String msg = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(msg, coffeeMaker.checkInventory());
        msg = "Coffee: 20\nMilk: 20\nSugar: 20\nChocolate: 20\n";
        coffeeMaker.addInventory("5", "5", "5", "5");
        assertEquals(msg, coffeeMaker.checkInventory());
    }

    /**
     * Given a coffee maker with the default inventory
     * When we purchase a beverage
     * Then we do not get an exception trying to read the inventory quantities.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test
    public void testCheckInventoryAfterPurchase() throws InventoryException {
        String msg = "Coffee: 15\nMilk: 15\nSugar: 15\nChocolate: 15\n";
        assertEquals(msg, coffeeMaker.checkInventory());
        msg = "Coffee: 20\nMilk: 20\nSugar: 20\nChocolate: 20\n";
        coffeeMaker.addInventory("5", "5", "5", "5");
        assertEquals(msg, coffeeMaker.checkInventory());
    }

    /**
     * Given a coffee maker with one valid recipe
     * When we make a coffee, selecting the valid recipe and paying more than
     * the coffee costs
     * Then we get the correct change back.
     */
    @Test
    public void testPurchaseBeverage() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(25, coffeeMaker.makeCoffee(0, 75));

        when(recipeBook.getRecipes()).thenReturn(recipes);
        assertEquals(10, coffeeMakerMock.makeCoffee(0, 60));
        verify(recipeBook, times(4)).getRecipes();
    }

    /**
     * Given a coffee maker with a valid recipe
     * When we try to purchase beverage that not enough inventory
     * Then we got the money back.
     *
     * @throws RecipeException if there was an error parsing the ingredient
     *                         amount when setting up the recipe.
     */
    @Test
    public void testPurchaseBeverageWhenNotEnoughInventory() throws RecipeException {
        assertTrue(coffeeMaker.addRecipe(recipe5));
        recipe5.setAmtCoffee("100");
        assertEquals(1000, coffeeMaker.makeCoffee(0, 1000));
        recipe5.setAmtMilk("100");
        assertEquals(1000, coffeeMaker.makeCoffee(0, 1000));
        recipe5.setAmtSugar("100");
        assertEquals(1000, coffeeMaker.makeCoffee(0, 1000));
        recipe5.setAmtChocolate("100");
        assertEquals(1000, coffeeMaker.makeCoffee(0, 1000));

        when(recipeBook.getRecipes()).thenReturn(recipes);
        assertEquals(100, coffeeMakerMock.makeCoffee(1, 100));
        verify(recipeBook, times(3)).getRecipes();
    }

    /**
     * Given a coffee maker with a valid recipe
     * When we try to purchase beverage with not enough money
     * Then we got the money back.
     */
    @Test
    public void testPurchaseBeverageWithNotEnoughMoney() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(25, coffeeMaker.makeCoffee(0, 25));
        assertEquals(50, coffeeMaker.makeCoffee(0, 100));

        when(recipeBook.getRecipes()).thenReturn(recipes);
        assertEquals(20, coffeeMakerMock.makeCoffee(0, 20));
        verify(recipeBook, times(2)).getRecipes();
    }

    /**
     * Given a coffee maker with a valid recipe
     * When we try to purchase beverage that not in a recipe book
     * Then we got the money back.
     */
    @Test
    public void testPurchaseBeverageInvalidRecipe() {
        assertTrue(coffeeMaker.addRecipe(recipe1));
        assertEquals(100, coffeeMaker.makeCoffee(1, 100));

        when(recipeBook.getRecipes()).thenReturn(new Recipe[]{null});
        assertEquals(50, coffeeMakerMock.makeCoffee(0, 50));
        verify(recipeBook, times(1)).getRecipes();
    }
}
