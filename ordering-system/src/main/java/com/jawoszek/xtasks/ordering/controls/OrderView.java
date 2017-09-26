package com.jawoszek.xtasks.ordering.controls;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public class OrderView extends ControlElement {

    private final ControlElement previousElement;

    public OrderView(Console console, Menu menu, Order order, ControlElement previousElement) {
        super(console, menu, order);
        this.previousElement = previousElement;
    }

    @Override
    protected String preActionMessage() {
        return "PLACEHOLDER FOR ORDER VIEW"; // TODO order view
    }

    @Override
    protected Map<Integer, String> actionOptions() {
        return ImmutableMap.of(
                0, "Return"
        );
    }

    @Override
    protected ControlElement getNextBasedOnChosenOption(int chosenOption) {
        switch (chosenOption) {
            case 0:
                return previousElement;
            default:
                throw new IllegalArgumentException(); // TODO description
        }
    }
}
