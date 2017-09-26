package com.jawoszek.xtasks.ordering.food;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Kacper
 */
public class Menu {

    private final Map<Integer, Lunch> lunches;
    private final Map<Integer, Drink> drinks;

    private Menu(Map<Integer, Lunch> lunches, Map<Integer, Drink> drinks) {
        this.lunches = lunches;
        this.drinks = drinks;
    }

    public static Menu standardMenu() {
        return new Menu(
                indexedMap(Lunch.values()),
                indexedMap(Drink.values())
        );
    }

    private static <T> Map<Integer, T> indexedMap(T[] array) {
        return IntStream
                .range(0, array.length)
                .boxed()
                .collect(
                        Collectors.toMap(
                                index -> index,
                                index -> array[index]));
    }
}
