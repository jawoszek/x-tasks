package com.jawoszek.xtasks.ordering.food;

/**
 * @author Kacper
 */
public enum Dessert {
    APPLE_PIE("apple pie"),
    CHOCOLATE_CAKE("chocolate cake");

    private final String name;

    Dessert(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
