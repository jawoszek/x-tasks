package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.currency.Currency;
import com.jawoszek.xtasks.ordering.food.Drink;

/**
 * @author Kacper
 */
public class DrinkOrder {

    private static final String DESCRIPTION_FORMAT = "Name:%s%s%s";

    private final Drink drink;
    private final boolean iceCubs;
    private final boolean lemon;

    DrinkOrder(Drink drink, boolean iceCubs, boolean lemon) {
        this.drink = drink;
        this.iceCubs = iceCubs;
        this.lemon = lemon;
    }

    Drink getDrink() {
        return drink;
    }

    public boolean isIceCubs() {
        return iceCubs;
    }

    public boolean isLemon() {
        return lemon;
    }

    public String getDescription(Currency currency) {
        return String.format(
                DESCRIPTION_FORMAT,
                drink.getDescription(currency),
                iceCubs ? "   with ice cubs" : "",
                lemon ? "   with lemon" : ""
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DrinkOrder that = (DrinkOrder) o;

        return iceCubs == that.iceCubs && lemon == that.lemon && drink == that.drink;
    }

    @Override
    public int hashCode() {
        int result = drink.hashCode();
        result = 31 * result + (iceCubs ? 1 : 0);
        result = 31 * result + (lemon ? 1 : 0);
        return result;
    }

    public static DrinkOrderBuilder builder() {
        return new DrinkOrderBuilder();
    }
}
