package com.jawoszek.xtasks.ordering.food;

import static com.jawoszek.xtasks.ordering.food.Cuisine.ITALIAN;
import static com.jawoszek.xtasks.ordering.food.Cuisine.MEXICAN;
import static com.jawoszek.xtasks.ordering.food.Cuisine.POLISH;
import static com.jawoszek.xtasks.ordering.food.Dessert.APPLE_PIE;
import static com.jawoszek.xtasks.ordering.food.Dessert.CHOCOLATE_CAKE;
import static com.jawoszek.xtasks.ordering.food.Dish.NACHOS;
import static com.jawoszek.xtasks.ordering.food.Dish.PIZZA;
import static com.jawoszek.xtasks.ordering.food.Dish.PORK_CHOP_WITH_POTATOES;

/**
 * @author Kacper
 */
public enum Lunch {
    STANDARD_POLISH_LUNCH(POLISH, PORK_CHOP_WITH_POTATOES, APPLE_PIE),
    STANDARD_MEXICO_LUNCH(MEXICAN, NACHOS, CHOCOLATE_CAKE),
    STANDARD_ITALIAN_LUNCH(ITALIAN, PIZZA, CHOCOLATE_CAKE);

    private static final String DESCRIPTION_FORMAT = "main dish: %s%ndessert: %s";

    private final Cuisine cuisine;
    private final Dish dish;
    private final Dessert dessert;

    Lunch(Cuisine cuisine, Dish dish, Dessert dessert) {
        this.cuisine = cuisine;
        this.dish = dish;
        this.dessert = dessert;
    }

    public String getDescription(){
        return String.format(DESCRIPTION_FORMAT, dish.getName(), dessert.getName());
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
}
