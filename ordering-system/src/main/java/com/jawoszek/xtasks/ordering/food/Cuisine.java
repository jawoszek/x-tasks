package com.jawoszek.xtasks.ordering.food;

import java.util.stream.Collectors;

import static com.jawoszek.xtasks.ordering.console.Console.LINE_SEPARATOR;
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

    public String getMenuPart() {
        String lunchesPart =
                stream(Lunch.values())
                        .filter(lunch -> lunch.getCuisine().equals(this))
                        .map(Lunch::getDescription)
                        .collect(Collectors.joining(LINE_SEPARATOR));

        return String.format(CUISINE_MENU_PART_FORMAT, name, lunchesPart);

    }
}
