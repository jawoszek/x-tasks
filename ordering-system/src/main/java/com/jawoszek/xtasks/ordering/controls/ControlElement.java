package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

/**
 * @author Kacper
 */
public abstract class ControlElement {

    protected final Console console;
    protected final Menu menu;
    protected final Order order;

    public ControlElement(Console console, Menu menu, Order order) {
        this.console = console;
        this.menu = menu;
        this.order = order;
    }

    public abstract ControlElement next();
}
