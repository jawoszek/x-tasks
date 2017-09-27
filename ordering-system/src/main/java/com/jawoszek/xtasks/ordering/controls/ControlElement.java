package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.currency.Currency;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

import java.util.Map;

import static java.lang.String.format;

/**
 * @author Kacper
 */
public abstract class ControlElement {

    private static final String CURRENT_ORDER_PRICE_LINE = "=== Current order price: %s ===";

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
        int price = order.getPrice();
        Currency currency = menu.getCurrency();

        String priceText = currency.convert(price) + currency.getCurrencySymbol();

        return format(CURRENT_ORDER_PRICE_LINE, priceText);
    }

    protected IllegalArgumentException illegalOptionException(int option) {
        return new IllegalArgumentException("Illegal option passed:" + option);
    }
}
