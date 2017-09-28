package com.jawoszek.xtasks.ordering.orders;

import com.jawoszek.xtasks.ordering.currency.Currency;
import com.jawoszek.xtasks.ordering.currency.USDollar;
import org.junit.Test;

import static com.jawoszek.xtasks.ordering.food.Drink.HALF_A_LITER_OF_LEMONADE;
import static com.jawoszek.xtasks.ordering.food.Drink.HALF_A_LITER_OF_PEPSI;
import static com.jawoszek.xtasks.ordering.food.Lunch.STANDARD_ITALIAN_LUNCH;
import static com.jawoszek.xtasks.ordering.food.Lunch.STANDARD_POLISH_LUNCH;
import static org.junit.Assert.assertEquals;

/**
 * @author Kacper
 */
public class OrderTest {

    private static final Currency currency = new USDollar();

    @Test
    public void getPriceWithoutOrders() {
        // given
        Order order = new Order(currency);
        int expectedPrice = 0;

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getPriceWithSingleLunch() {
        // given
        Order order = new Order(currency);
        order.addLunch(STANDARD_POLISH_LUNCH, 1);
        int expectedPrice = STANDARD_POLISH_LUNCH.getPrice();

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getPriceWithTwoLunches() {
        // given
        Order order = new Order(currency);
        order.addLunch(STANDARD_POLISH_LUNCH, 2);
        int expectedPrice = STANDARD_POLISH_LUNCH.getPrice() * 2;

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getPriceWithSingleDrink() {
        // given
        Order order = new Order(currency);
        DrinkOrder drinkOrder = new DrinkOrder(HALF_A_LITER_OF_PEPSI, false, false);
        order.addDrinks(drinkOrder, 1);
        int expectedPrice = HALF_A_LITER_OF_PEPSI.getPrice();

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getPriceWithTwoDrinks() {
        // given
        Order order = new Order(currency);
        DrinkOrder drinkOrder = new DrinkOrder(HALF_A_LITER_OF_LEMONADE, false, false);
        order.addDrinks(drinkOrder, 2);
        int expectedPrice = HALF_A_LITER_OF_LEMONADE.getPrice() * 2;

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }

    @Test
    public void getPriceWithLunchAndDrink() {
        // given
        Order order = new Order(currency);
        DrinkOrder drinkOrder = new DrinkOrder(HALF_A_LITER_OF_LEMONADE, false, false);
        order.addDrinks(drinkOrder, 1);
        order.addLunch(STANDARD_ITALIAN_LUNCH, 1);
        int expectedPrice = STANDARD_ITALIAN_LUNCH.getPrice() + HALF_A_LITER_OF_LEMONADE.getPrice();

        // when
        int actualPrice = order.getPrice();

        // then
        assertEquals(expectedPrice, actualPrice);
    }
}