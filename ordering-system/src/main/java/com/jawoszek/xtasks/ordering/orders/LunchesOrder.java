package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Lunch;

import java.util.EnumMap;
import java.util.Map;

/**
 * @author Kacper
 */
public class LunchesOrder {

    private final Map<Lunch, Integer> lunches = new EnumMap<>(Lunch.class);

    public void addLunch(Lunch lunch, int amount) {
        lunches.merge(lunch, amount, (current, added) -> current + added);
    }

    public int getPrice() {
        return Order.getPrice(lunches, LunchesOrder::calculatePriceFromEntry);
    }

    private static int calculatePriceFromEntry(Map.Entry<Lunch, Integer> entry) {
        return entry.getKey().getPrice() * entry.getValue();
    }
}
