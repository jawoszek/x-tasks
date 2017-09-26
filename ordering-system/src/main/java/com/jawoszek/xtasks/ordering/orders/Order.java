package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.food.Lunch;

import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;

/**
 * @author Kacper
 */
public class Order {

    private static final String ORDER_FORMAT = "Lunches:%n%s%nDrinks:%n%s%n";

    private final DrinksOrder drinksOrder = new DrinksOrder();
    private final LunchesOrder lunchesOrder = new LunchesOrder();

    public void addDrinks(DrinkOrder drinkOrder, int amount) {
        drinksOrder.addDrinks(drinkOrder, amount);
    }

    public void addLunch(Lunch lunch, int amount) {
        lunchesOrder.addLunch(lunch, amount);
    }

    public int getPrice() {
        return drinksOrder.getPrice() + lunchesOrder.getPrice();
    }

    public String getOrderText() {
        return String.format(ORDER_FORMAT, lunchesOrder.getOrderText(), drinksOrder.getOrderText());
    }

    static <T> int getPrice(Map<T, Integer> map, Function<Entry<T, Integer>, Integer> fromEntryToPrice) {
        return map
                .entrySet()
                .stream()
                .map(fromEntryToPrice)
                .reduce(0, (acc, price) -> acc + price);
    }
}
