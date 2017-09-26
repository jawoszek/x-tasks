package com.jawoszek.xtasks.ordering.controls;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import com.jawoszek.xtasks.ordering.orders.Order;

/**
 * @author Kacper
 */
public class NewOrder extends ControlElement {

    public NewOrder(Console console, Menu menu, Order order) {
        super(console, menu, order);
    }

    @Override
    public ControlElement next() {
        return null; // TODO implement
    }

    public static NewOrder newOrder(Console console, Menu menu){
        return new NewOrder(console, menu, new Order());
    }
}
