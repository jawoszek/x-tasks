package com.jawoszek.xtasks.ordering.food;

import static com.jawoszek.xtasks.ordering.food.Cuisine.*;
import static com.jawoszek.xtasks.ordering.food.Dessert.APPLE_PIE;
import static com.jawoszek.xtasks.ordering.food.Dessert.CHOCOLATE_CAKE;
import static com.jawoszek.xtasks.ordering.food.Dish.*;
import static java.lang.String.format;

/**
 * @author Kacper
 */
public enum Lunch {
    STANDARD_POLISH_LUNCH(POLISH, PORK_CHOP_WITH_POTATOES, APPLE_PIE, 1299),
    STANDARD_MEXICO_LUNCH(MEXICAN, NACHOS, CHOCOLATE_CAKE, 1599),
    STANDARD_ITALIAN_LUNCH(ITALIAN, PIZZA, CHOCOLATE_CAKE, 1899);

    private static final String DESCRIPTION_FORMAT = "Main dish:%s   Dessert:%s   Price:%s";

    private final Cuisine cuisine;
    private final Dish dish;
    private final Dessert dessert;
    private final int price;

    Lunch(Cuisine cuisine, Dish dish, Dessert dessert, int price) {
        this.cuisine = cuisine;
        this.dish = dish;
        this.dessert = dessert;
        this.price = price;
    }

    public Cuisine getCuisine() {
        return cuisine;
    }

    public Dish getDish() {
        return dish;
    }

    public Dessert getDessert() {
        return dessert;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription(){
        return format(DESCRIPTION_FORMAT, dish.getName(), dessert.getName(), price);
    }
}
