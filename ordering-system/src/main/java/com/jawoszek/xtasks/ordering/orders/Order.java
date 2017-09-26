package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Drink;
import com.jawoszek.xtasks.ordering.food.Lunch;

/**
 * @author Kacper
 */
public class Order {
    private final DrinksOrder drinksOrder = new DrinksOrder();
    private final LunchesOrder lunchesOrder = new LunchesOrder();

    public void addDrinks(Drink drink, boolean iceCubs, boolean lemon, int amount) {
        drinksOrder.addDrinks(drink, iceCubs, lemon, amount);
    }

    public void addLunch(Lunch lunch, int amount) {
        lunchesOrder.addLunch(lunch, amount);
    }
}
