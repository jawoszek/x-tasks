package com.jawoszek.xtasks.ordering.food;

/**
 * @author Kacper
 */
public enum Cuisine {
    POLISH ("Polish"),
    MEXICAN ("Mexican"),
    ITALIAN ("Italian");

    private final String name;

    Cuisine(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
