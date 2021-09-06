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
import edu.ncsu.csc326.coffeemaker.Inventory;
import edu.ncsu.csc326.coffeemaker.exceptions.InventoryException;
import edu.ncsu.csc326.coffeemaker.exceptions.RecipeException;

import static org.junit.Assert.*;

/**
 * Unit tests for Inventory class.
 *
 * @author Chayapol Chaipongsawalee 6210545947
 */
public class InventoryTest {

    private Inventory inventory;

    /**
     * Initializes an Inventory object we wish to test.
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Before
    public void setUp() throws InventoryException {
        inventory = new Inventory();
    }

    /**
     * Given an inventory
     * When we try to add chocolate with invalid input
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test
    public void testAddChocolateInvalid() throws InventoryException {
        inventory.addChocolate("abcd");
        inventory.addChocolate("-abcd");
    }

    /**
     * Given an inventory
     * When we try to add chocolate with negative number
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddChocolateNegative() throws InventoryException {
        inventory.addChocolate("-1");
        inventory.addChocolate("-200");
    }

    /**
     * Given an inventory
     * When we try to add milk with invalid input
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkInvalid() throws InventoryException {
        inventory.addMilk("abcd");
        inventory.addMilk("-abcd");
    }

    /**
     * Given an inventory
     * When we try to add milk with negative number
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddMilkNegative() throws InventoryException {
        inventory.addMilk("-1");
        inventory.addMilk("-200");
    }

    /**
     * Given an inventory
     * When we try to add sugar with invalid input
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarInvalid() throws InventoryException {
        inventory.addSugar("abcd");
        inventory.addSugar("-abcd");
    }

    /**
     * Given an inventory
     * When we try to add sugar with negative number
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddSugarNegative() throws InventoryException {
        inventory.addSugar("-1");
        inventory.addSugar("-200");
    }

    /**
     * Given an inventory
     * When we try to add coffee with invalid input
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeInvalid() throws InventoryException {
        inventory.addCoffee("abcd");
        inventory.addCoffee("-abcd");
    }

    /**
     * Given an inventory
     * When we try to add coffee with negative number
     * Then it can't be added
     *
     * @throws InventoryException if there was an error parsing the quantity
     *                            to a positive integer.
     */
    @Test(expected = InventoryException.class)
    public void testAddCoffeeNegative() throws InventoryException {
        inventory.addCoffee("-1");
        inventory.addCoffee("-200");
    }

    /**
     * Given an inventory
     * When we try to set each ingredient's amount with negative number
     * Then the amount won't change
     */
    @Test
    public void testSetNegativeIngredients() {
        inventory.setChocolate(-1);
        assertEquals(15, inventory.getChocolate());
        inventory.setCoffee(-2);
        assertEquals(15, inventory.getCoffee());
        inventory.setMilk(-3);
        assertEquals(15, inventory.getMilk());
        inventory.setSugar(-4);
        assertEquals(15, inventory.getSugar());
    }
}
