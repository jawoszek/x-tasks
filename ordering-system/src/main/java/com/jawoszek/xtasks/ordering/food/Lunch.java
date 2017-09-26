package com.jawoszek.xtasks.ordering.food;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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
    STANDARD_POLISH_LUNCH(POLISH, PORK_CHOP_WITH_POTATOES, APPLE_PIE, 1299),
    STANDARD_MEXICO_LUNCH(MEXICAN, NACHOS, CHOCOLATE_CAKE, 1599),
    STANDARD_ITALIAN_LUNCH(ITALIAN, PIZZA, CHOCOLATE_CAKE, 1899);

    private static final String DESCRIPTION_FORMAT = "main dish: %s%ndessert: %s";

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

    public int getPrice() {
        return price;
    }

    public static Map<Integer, Lunch> getIndexedLunches(){
        return IntStream
                .range(0, Lunch.values().length)
                .boxed()
                .collect(
                        Collectors.toMap(
                                index -> index,
                                index -> Lunch.values()[index]
                        )
                );
    }
}
