package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Drink;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kacper
 */
public class DrinksOrder {

    private final Map<DrinkOrder, Integer> drinks = new HashMap<>();

    public void addDrinks(DrinkOrder drinkOrder, int amount) {
        drinks.merge(drinkOrder, amount, (current, added) -> current + added);
    }

    public int getPrice() {
        return Order.getPrice(drinks, DrinksOrder::calculatePriceFromEntry);
    }

    private static int calculatePriceFromEntry(Map.Entry<DrinkOrder, Integer> entry) {
        return entry.getKey().getDrink().getPrice() * entry.getValue();
    }
}
