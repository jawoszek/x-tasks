package com.jawoszek.xtasks.ordering.controls;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.DrinkOrder;
import com.jawoszek.xtasks.ordering.orders.DrinkOrderBuilder;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public class AdditionalDrinkProperties extends ControlElement {

    private final DrinkOrderBuilder builder;

    AdditionalDrinkProperties(Console console, Menu menu, Order order, DrinkOrderBuilder builder) {
        super(console, menu, order);
        this.builder = builder;
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return ImmutableMap.of(
                0, "Ice cubs & lemon",
                1, "Ice cubs",
                2, "Lemon",
                3, "Neither"
        );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        DrinkOrder drinkOrder;
        switch (chosenOption) {
            case 0:
                drinkOrder = builder.withIceCubs(true).withLemon(true).build();
                break;
            case 1:
                drinkOrder = builder.withIceCubs(true).withLemon(false).build();
                break;
            case 2:
                drinkOrder = builder.withIceCubs(false).withLemon(true).build();
                break;
            case 3:
                drinkOrder = builder.withIceCubs(false).withLemon(false).build();
                break;
            default:
                throw illegalOptionException(chosenOption);
        }
        order.addDrinks(drinkOrder, 1);
        return new OrderControl(console, menu, order);
    }
}
