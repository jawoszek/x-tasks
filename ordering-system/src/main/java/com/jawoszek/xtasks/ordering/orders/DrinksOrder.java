package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.currency.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static com.google.common.base.Joiner.on;
import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;
import static com.jawoszek.xtasks.ordering.orders.Order.orderRemovalFunction;

/**
 * @author Kacper
 */
class DrinksOrder {

    private static final String KEY_VALUE_SEPARATOR = " - ";

    private final Currency currency;
    private final Map<DrinkOrder, Integer> drinks = new HashMap<>();

    DrinksOrder(Currency currency) {
        this.currency = currency;
    }

    void addDrinks(DrinkOrder drinkOrder, int amount) {
        drinks.merge(drinkOrder, amount, (current, added) -> current + added);
    }

    int getPrice() {
        return Order.getPrice(drinks, DrinksOrder::calculatePriceFromEntry);
    }

    String getOrderText() {
        Map<String, String> descriptions = Order.getDescriptions(drinks, this::getDescriptionFromEntry);

        return on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(descriptions);
    }

    List<DrinkOrder> getDrinkOrdersAsList() {
        return new ArrayList<>(drinks.keySet());
    }

    void removeOrders(DrinkOrder drinkOrder, int amount) {
        drinks.computeIfPresent(drinkOrder, orderRemovalFunction(amount));
    }

    private static int calculatePriceFromEntry(Entry<DrinkOrder, Integer> entry) {
        return entry.getKey().getDrink().getPrice() * entry.getValue();
    }

    private String getDescriptionFromEntry(Entry<DrinkOrder, Integer> entry) {
        return entry.getKey().getDescription(currency);
    }
}
