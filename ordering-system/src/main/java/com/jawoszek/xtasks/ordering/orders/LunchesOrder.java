package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Lunch;

import java.util.EnumMap;
import java.util.Map;

import static com.google.common.base.Joiner.on;
import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;

/**
 * @author Kacper
 */
public class LunchesOrder {

    private static final String KEY_VALUE_SEPARATOR = " - ";

    private final Map<Lunch, Integer> lunches = new EnumMap<>(Lunch.class);

    public void addLunch(Lunch lunch, int amount) {
        lunches.merge(lunch, amount, (current, added) -> current + added);
    }

    public int getPrice() {
        return Order.getPrice(lunches, LunchesOrder::calculatePriceFromEntry);
    }

    public String getOrderText() {
        return on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(lunches);
    }

    private static int calculatePriceFromEntry(Map.Entry<Lunch, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }
}
