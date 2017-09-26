package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public class AddLunch extends ControlElement {

    public AddLunch(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return null;
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        return null;
    }
}
