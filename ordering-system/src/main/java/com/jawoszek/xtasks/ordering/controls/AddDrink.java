package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Drink;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.DrinkOrder;
import com.jawoszek.xtasks.ordering.orders.DrinkOrderBuilder;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Kacper
 */
public class AddDrink extends ControlElement {

    public AddDrink(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return menu.getDrinks()
                .entrySet()
                .stream()
                .collect(
                        Collectors.toMap(
                                Map.Entry::getKey,
                                entry -> entry.getValue().getDescription()
                        )
                );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        if (!actionOptions().containsKey(chosenOption)){
            throw new IllegalArgumentException(); // TODO description
        }
        Drink drinkToAdd = menu.getDrinks().get(chosenOption);
        DrinkOrderBuilder builder = DrinkOrder.builder().withDrink(drinkToAdd);
        return new AdditionalDrinkProperties(console, menu, order, builder);
    }
}
