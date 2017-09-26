package com.jawoszek.xtasks.ordering.food;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;
import static java.util.Arrays.stream;

/**
 * @author Kacper
 */
public class Menu {

    private static final String MENU_TEXT_FORMAT = "Menu:%nLunches:%n%s%nDrinks:%n%s";

    private final Map<Integer, Lunch> lunches;
    private final Map<Integer, Drink> drinks;

    private Menu(Map<Integer, Lunch> lunches, Map<Integer, Drink> drinks) {
        this.lunches = lunches;
        this.drinks = drinks;
    }

    public Map<Integer, Lunch> getLunches() {
        return lunches;
    }

    public Map<Integer, Drink> getDrinks() {
        return drinks;
    }

    public String getMenuText() {
        return String.format(MENU_TEXT_FORMAT, getLunchMenuPart(), getDrinkMenuPart());
    }

    private String getLunchMenuPart() {
        return stream(Cuisine.values())
                .map(Cuisine::getMenuPart)
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String getDrinkMenuPart() {
        return drinks
                .values()
                .stream()
                .map(Drink::getDescription)
                .collect(Collectors.joining(LINE_SEPARATOR));
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
