package com.jawoszek.xtasks.ordering.orders;

import java.util.HashMap;
import java.util.Map;

import static com.google.common.base.Joiner.on;
import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;

/**
 * @author Kacper
 */
public class DrinksOrder {

    private static final String KEY_VALUE_SEPARATOR = " - ";

    private final Map<DrinkOrder, Integer> drinks = new HashMap<>();

    public void addDrinks(DrinkOrder drinkOrder, int amount) {
        drinks.merge(drinkOrder, amount, (current, added) -> current + added);
    }

    public int getPrice() {
        return Order.getPrice(drinks, DrinksOrder::calculatePriceFromEntry);
    }

    public String getOrderText() {
        return on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(drinks);
    }

    private static int calculatePriceFromEntry(Map.Entry<DrinkOrder, Integer> entry) {
        return entry.getKey().getDrink().getPrice() * entry.getValue();
    }
}
