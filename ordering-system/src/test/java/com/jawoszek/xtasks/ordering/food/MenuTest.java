package com.jawoszek.xtasks.ordering.food;

import com.google.common.collect.ImmutableMap;
import com.jawoszek.xtasks.ordering.currency.USDollar;
import org.junit.Test;

import static java.lang.String.format;
import static org.junit.Assert.assertEquals;

/**
 * @author Kacper
 */
public class MenuTest {

    @Test
    public void getSimpleMenuText() {
        // given
        Menu menu = new Menu(
                ImmutableMap.of(1, Lunch.STANDARD_POLISH_LUNCH),
                ImmutableMap.of(1, Drink.HALF_A_LITER_OF_WATER),
                ImmutableMap.of(1, Cuisine.POLISH),
                new USDollar()
        );

        // when
        String actualMenuText = menu.getMenuText();

        // then
        assertEquals(SIMPLE_MENU_TEXT, actualMenuText);
    }

    private static final String SIMPLE_MENU_TEXT = format(
            "Menu:%n" +
                    "Lunches:%n" +
                    "  Polish:%n" +
                    "    Main dish:pork chop with potatoes   Dessert:apple pie   Price:12.99$%n" +
                    "    Main dish:ruthenian pierogi   Dessert:apple pie   Price:10.99$%n" +
                    "Drinks:%n" +
                    "  Name:water   Amount:500   Price:5.99$"
    );
}