package com.jawoszek.xtasks.ordering;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.controls.ControlElement;
import com.jawoszek.xtasks.ordering.food.Menu;

import static com.jawoszek.xtasks.ordering.controls.NewOrderOrExit.newOrder;

/**
 * @author Kacper
 */
public class Application {
    public static void main(String[] args) {
        Console console = Console.standardConsole();
        Menu menu = Menu.standardMenu();
        try {
            new Application().start(console, menu);
        }finally {
            console.close();
        }
    }

    public void start(Console console, Menu menu) {
        ControlElement currentControl = newOrder(console, menu);
        while(currentControl != null) {
            currentControl = currentControl.next();
        }
    }

}
