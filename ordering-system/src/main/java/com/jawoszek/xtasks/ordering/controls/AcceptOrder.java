package com.jawoszek.xtasks.ordering.controls;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

import static com.jawoszek.xtasks.ordering.controls.NewOrder.newOrder;

/**
 * @author Kacper
 */
public class AcceptOrder extends ControlElement {

    AcceptOrder(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return ImmutableMap.of(
                0, "Continue"
        );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        switch (chosenOption) {
            case 0:
                console.printMessage("Order accepted");
                return newOrder(console, menu);
            default:
                throw illegalOptionException(chosenOption);
        }
    }
}
