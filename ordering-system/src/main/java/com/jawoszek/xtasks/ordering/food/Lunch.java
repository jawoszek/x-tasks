package com.jawoszek.xtasks.ordering.food;

import com.jawoszek.xtasks.ordering.currency.Currency;

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
    LIGHT_POLISH_LUNCH(POLISH, RUTHENIAN_PIEROGI, APPLE_PIE, 1099),
    STANDARD_MEXICO_LUNCH(MEXICAN, NACHOS, CHOCOLATE_CAKE, 1599),
    LIGHT_MEXICO_LUNCH(MEXICAN, TACOS, CHOCOLATE_CAKE, 1399),
    STANDARD_ITALIAN_LUNCH(ITALIAN, PIZZA, CHOCOLATE_CAKE, 1899),
    LIGHT_ITALIAN_LUNCH(ITALIAN, FARFALLE, CHOCOLATE_CAKE, 1299);

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

    public String getDescription(Currency currency) {
        String priceText = currency.convert(price) + currency.getCurrencySymbol();

        return format(DESCRIPTION_FORMAT, dish.getName(), dessert.getName(), priceText);
    }
}
