package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

/**
 * @author Kacper
 */
public abstract class ControlElement {

    protected static final String CURRENT_ORDER_PRICE_LINE = "=== Current order price: %d ===";

    protected final Console console;
    protected final Menu menu;
    protected final Order order;

    public ControlElement(Console console, Menu menu, Order order) {
        this.console = console;
        this.menu = menu;
        this.order = order;
    }

    public ControlElement next() {
        console.clearScreen();
        console.printMessage(preActionMessage());
        return action();
    }

    protected ControlElement action() {
        if (actionOptions().isEmpty()) {
            throw new IllegalStateException(); // TODO description
        }

        console.printOptions(actionOptions());
        int chosenOption = readChosenOption();
        return getNextBasedOnChosenOption(chosenOption);
    }

    protected int readChosenOption() {
        int chosenOption = -1;
        while (!actionOptions().containsKey(chosenOption)) {
            chosenOption = console.getNumberFromInput();
        }
        return chosenOption;
    }

    protected abstract Map<Integer, String> actionOptions();

    protected abstract ControlElement getNextBasedOnChosenOption(int chosenOption);

    protected String preActionMessage() {
        return String.format(CURRENT_ORDER_PRICE_LINE, order.getPrice());
    }
}
