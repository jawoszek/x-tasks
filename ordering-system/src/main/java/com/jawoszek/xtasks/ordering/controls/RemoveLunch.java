package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Lunch;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

import static java.util.stream.Collectors.toMap;

/**
 * @author Kacper
 */
public class RemoveLunch extends ControlElement {

    public RemoveLunch(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        Map<Integer, String> actions =
                order.getLunchesInOrder()
                        .entrySet()
                        .stream()
                        .collect(
                                toMap(
                                        Map.Entry::getKey,
                                        entry -> entry.getValue()
                                                .getDescription(menu.getCurrency())
                                )
                        );

        actions.put(actions.size(), "Back");
        return actions;
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        Map<Integer, Lunch> lunches = order.getLunchesInOrder();

        if (chosenOption == lunches.size()) {
            return new OrderControl(console, menu, order);
        }

        if (!lunches.containsKey(chosenOption)) {
            throw illegalOptionException(chosenOption);
        }
        order.removeLunches(lunches.get(chosenOption), 1);

        return new OrderControl(console, menu, order);
    }
}
