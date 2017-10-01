package com.jawoszek.xtasks.ordering.food;

import com.jawoszek.xtasks.ordering.currency.Currency;
import com.jawoszek.xtasks.ordering.currency.USDollar;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;

/**
 * @author Kacper
 */
public class Menu {

    private static final String MENU_TEXT_FORMAT = "Menu:%nLunches:%n%s%nDrinks:%n%s";

    private final Map<Integer, Lunch> lunches;
    private final Map<Integer, Drink> drinks;
    private final Map<Integer, Cuisine> cuisines;
    private final Currency currency;

    public Menu(Map<Integer, Lunch> lunches, Map<Integer, Drink> drinks, Map<Integer, Cuisine> cuisines, Currency currency) {
        this.lunches = lunches;
        this.drinks = drinks;
        this.cuisines = cuisines;
        this.currency = currency;
    }

    public Map<Integer, Lunch> getLunches() {
        return lunches;
    }

    public Map<Integer, Drink> getDrinks() {
        return drinks;
    }

    public Map<Integer, Cuisine> getCuisines() {
        return cuisines;
    }

    public Currency getCurrency() {
        return currency;
    }

    public String getMenuText() {
        return String.format(MENU_TEXT_FORMAT, getLunchMenuPart(), getDrinkMenuPart());
    }

    private String getLunchMenuPart() {
        return cuisines
                .values()
                .stream()
                .map(cuisine -> cuisine.getMenuPart(currency))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    private String getDrinkMenuPart() {
        return drinks
                .values()
                .stream()
                .map(drink -> drink.getMenuPosition(currency))
                .collect(Collectors.joining(LINE_SEPARATOR));
    }

    public static Menu standardMenu() {
        return new Menu(
                indexedMap(Lunch.values()),
                indexedMap(Drink.values()),
                indexedMap(Cuisine.values()),
                new USDollar()
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
