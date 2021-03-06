package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Drink;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.DrinkOrder;
import com.jawoszek.xtasks.ordering.orders.DrinkOrderBuilder;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

/**
 * @author Kacper
 */
public class AddDrink extends ControlElement {

    AddDrink(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return menu.getDrinks()
                .entrySet()
                .stream()
                .collect(
                        toMap(
                                Entry::getKey,
                                entry -> entry.getValue()
                                        .getDescription(menu.getCurrency())
                        )
                );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        if (!actionOptions().containsKey(chosenOption)) {
            throw illegalOptionException(chosenOption);
        }
        Drink drinkToAdd = menu.getDrinks().get(chosenOption);
        DrinkOrderBuilder builder = DrinkOrder.builder().withDrink(drinkToAdd);
        return new AdditionalDrinkProperties(console, menu, order, builder);
    }
}
