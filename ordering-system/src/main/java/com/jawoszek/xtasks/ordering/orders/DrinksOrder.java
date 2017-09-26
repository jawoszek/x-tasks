package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Drink;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kacper
 */
public class DrinksOrder {

    private final Map<DrinkOrder, Integer> drinks = new HashMap<>();

    public void addDrinks(Drink drink, boolean iceCubs, boolean lemon, int amount) {
        DrinkOrder drinkOrder = new DrinkOrder(drink, iceCubs, lemon);

        drinks.merge(drinkOrder, amount, (current, added) -> current + added);
    }
}
