package com.jawoszek.xtasks.ordering.food;

/**
 * @author Kacper
 */
public enum Dish {
    PORK_CHOP_WITH_POTATOES("pork chop with potatoes"),
    RUTHENIAN_PIEROGI("ruthenian pierogi"),
    TACOS("tacos with pork and cheese"),
    NACHOS("nachos"),
    PIZZA("pizza margherita"),
    FARFALLE("farfalle with tomato sauce");

    private final String name;

    Dish(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
