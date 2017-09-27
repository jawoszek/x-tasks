package com.jawoszek.xtasks.ordering.controls;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public class OrderControl extends ControlElement {

    OrderControl(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return ImmutableMap.of(
                0, "Show order",
                1, "Modify order",
                2, "Accept order",
                3, "Cancel order"
        );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        switch (chosenOption) {
            case 0:
                return new OrderView(console, menu, order, this);
            case 1:
                return new ModifyOrder(console, menu, order);
            case 2:
                return new AcceptOrder(console, menu, order);
            case 3:
                return new CancelOrder(console, menu, order);
            default:
                throw illegalOptionException(chosenOption);
        }
    }
}
