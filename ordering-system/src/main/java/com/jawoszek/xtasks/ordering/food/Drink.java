package com.jawoszek.xtasks.ordering.food;

/**
 * @author Kacper
 */
public enum Drink {
    HALF_A_LITER_OF_WATER("water", 500, 599),
    HALF_A_LITER_OF_PEPSI("pepsi", 500, 699),
    TWO_HUNDRED_MILLIS_OF_PEPSI("pepsi", 200, 399),
    HALF_A_LITER_OF_LEMONADE("lemonade", 500, 599);

    private final String name;
    private final int amountInMilliliters;
    private final int price;

    Drink(String name, int amountInMilliliters, int price) {
        this.name = name;
        this.amountInMilliliters = amountInMilliliters;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getAmountInMilliliters() {
        return amountInMilliliters;
    }

    public int getPrice() {
        return price;
    }
}