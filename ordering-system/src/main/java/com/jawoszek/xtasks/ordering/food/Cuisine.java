package com.jawoszek.xtasks.ordering.food;

import com.jawoszek.xtasks.ordering.currency.Currency;

import java.util.stream.Collectors;

import static com.jawoszek.xtasks.ordering.console.Console.*;
import static java.util.Arrays.stream;

/**
 * @author Kacper
 */
public enum Cuisine {
    POLISH("Polish"),
    MEXICAN("Mexican"),
    ITALIAN("Italian");

    private static final String CUISINE_MENU_PART_FORMAT = "%s:%n%s";

    private final String name;

    Cuisine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getMenuPart(Currency currency) {
        String lunchesPart =
                stream(Lunch.values())
                        .filter(lunch -> lunch.getCuisine().equals(this))
                        .map(lunch -> lunchMenuPosition(lunch, currency))
                        .collect(Collectors.joining(LINE_SEPARATOR));

        return String.format(CUISINE_MENU_PART_FORMAT, menuPosition(), lunchesPart);

    }

    private String menuPosition() {
        return SMALL_INDENTATION + name;
    }

    private static String lunchMenuPosition(Lunch lunch, Currency currency) {
        return BIG_INDENTATION + lunch.getDescription(currency);
    }
}
