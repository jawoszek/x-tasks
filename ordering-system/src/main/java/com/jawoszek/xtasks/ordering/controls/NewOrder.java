package com.jawoszek.xtasks.ordering.controls;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public class NewOrder extends ControlElement {

    private NewOrder(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return ImmutableMap.of(
                0, "Create new order",
                1, "Show menu",
                2, "Exit application"
        );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        switch (chosenOption) {
            case 0:
                return new OrderControl(console, menu, order);
            case 1:
                return new MenuView(console, menu, order, this);
            case 2:
                return null;
            default:
                throw illegalOptionException(chosenOption);
        }
    }

    public static NewOrder newOrder(Console console, Menu menu) {
        return new NewOrder(console, menu, new Order());
    }
}
