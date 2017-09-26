package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Drink;

/**
 * @author Kacper
 */
public class DrinkOrderBuilder {
    private Drink drink;
    private boolean iceCubs;
    private boolean lemon;

    DrinkOrderBuilder() {

    }

    public DrinkOrderBuilder withDrink(Drink drink) {
        this.drink = drink;
        return this;
    }

    public DrinkOrderBuilder withIceCubs(boolean iceCubs) {
        this.iceCubs = iceCubs;
        return this;
    }

    public DrinkOrderBuilder withLemon(boolean lemon) {
        this.lemon = lemon;
        return this;
    }

    public DrinkOrder build() {
        if (drink == null) {
            throw new IllegalStateException(); //TODO description
        }
        return new DrinkOrder(drink, iceCubs, lemon);
    }
}
