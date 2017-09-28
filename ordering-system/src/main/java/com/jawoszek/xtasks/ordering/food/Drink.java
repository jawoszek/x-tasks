package com.jawoszek.xtasks.ordering.food;

import com.jawoszek.xtasks.ordering.currency.Currency;

import static com.jawoszek.xtasks.ordering.console.Console.SMALL_INDENTATION;
import static java.lang.String.format;

/**
 * @author Kacper
 */
public enum Drink {
    HALF_A_LITER_OF_WATER("water", 500, 599),
    HALF_A_LITER_OF_PEPSI("pepsi", 500, 699),
    TWO_HUNDRED_MILLIS_OF_PEPSI("pepsi", 200, 399),
    HALF_A_LITER_OF_LEMONADE("lemonade", 500, 599);

    private static final String DRINK_DESCRIPTION_FORMAT = "Name:%s   Amount:%s   Price:%s";

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

    public String getDescription(Currency currency) {
        String priceText = currency.convert(price) + currency.getCurrencySymbol();

        return format(DRINK_DESCRIPTION_FORMAT, name, amountInMilliliters, priceText);
    }

    public String getMenuPosition(Currency currency){
        return SMALL_INDENTATION + getDescription(currency);
    }
}
