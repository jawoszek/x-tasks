package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.DrinkOrder;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

/**
 * @author Kacper
 */
public class RemoveDrink extends ControlElement {

    public RemoveDrink(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        Map<Integer, String> actions =
                order.getDrinksInOrder()
                        .entrySet()
                        .stream()
                        .collect(
                                toMap(
                                        Entry::getKey,
                                        entry -> entry.getValue()
                                                .getDescription(menu.getCurrency())
                                )
                        );

        actions.put(actions.size(), "Back");
        return actions;
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        Map<Integer, DrinkOrder> drinkOrders = order.getDrinksInOrder();

        if (chosenOption == drinkOrders.size()) {
            return new OrderControl(console, menu, order);
        }

        if (!drinkOrders.containsKey(chosenOption)) {
            throw illegalOptionException(chosenOption);
        }
        order.removeDrinks(drinkOrders.get(chosenOption), 1);

        return new OrderControl(console, menu, order);
    }
}
