package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Lunch;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;
import java.util.Map.Entry;

import static java.util.stream.Collectors.toMap;

/**
 * @author Kacper
 */
public class AddLunch extends ControlElement {

    AddLunch(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return menu.getLunches()
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
        Lunch lunchToAdd = menu.getLunches().get(chosenOption);
        order.addLunch(lunchToAdd, 1);
        return new OrderControl(console, menu, order);
    }
}
