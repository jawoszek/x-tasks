package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.currency.Currency;
import com.jawoszek.xtasks.ordering.food.Lunch;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static com.google.common.base.Joiner.on;
import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;
import static com.jawoszek.xtasks.ordering.orders.Order.orderRemovalFunction;

/**
 * @author Kacper
 */
class LunchesOrder {

    private static final String KEY_VALUE_SEPARATOR = " - Count:";

    private final Currency currency;
    private final Map<Lunch, Integer> lunches = new EnumMap<>(Lunch.class);

    LunchesOrder(Currency currency) {
        this.currency = currency;
    }

    void addLunch(Lunch lunch, int amount) {
        lunches.merge(lunch, amount, (current, added) -> current + added);
    }

    int getPrice() {
        return Order.getPrice(lunches, LunchesOrder::calculatePriceFromEntry);
    }

    String getOrderText() {
        Map<String, String> descriptions = Order.getDescriptions(lunches, this::getDescriptionFromEntry);

        return on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(descriptions);
    }

    List<Lunch> getLunchesAsList() {
        return new ArrayList<>(lunches.keySet());
    }

    void removeOrder(Lunch lunch, int amount) {
        lunches.computeIfPresent(lunch, orderRemovalFunction(amount));
    }

    private static int calculatePriceFromEntry(Entry<Lunch, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }

    private String getDescriptionFromEntry(Entry<Lunch, Integer> entry) {
        return entry.getKey().getDescription(currency);
    }
}
