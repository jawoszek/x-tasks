package com.jawoszek.xtasks.ordering.currency;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Kacper
 */
public class USDollarTest {

    private static final USDollar dollar = new USDollar();

    @Test
    public void convertTenDollars() throws Exception {
        // given
        int priceInPennies = 1000;
        String expectedPriceInDollars = "10.00";

        // when
        String actualPriceInDollars = dollar.convert(priceInPennies);

        // then
        assertEquals(expectedPriceInDollars, actualPriceInDollars);
    }

    @Test
    public void convertOneDollarNinetyNinePennies() throws Exception {
        // given
        int priceInPennies = 199;
        String expectedPriceInDollars = "1.99";

        // when
        String actualPriceInDollars = dollar.convert(priceInPennies);

        // then
        assertEquals(expectedPriceInDollars, actualPriceInDollars);
    }

    @Test
    public void convertNinetyNinePennies() throws Exception {
        // given
        int priceInPennies = 99;
        String expectedPriceInDollars = "0.99";

        // when
        String actualPriceInDollars = dollar.convert(priceInPennies);

        // then
        assertEquals(expectedPriceInDollars, actualPriceInDollars);
    }

    @Test
    public void convertNinePennies() throws Exception {
        // given
        int priceInPennies = 9;
        String expectedPriceInDollars = "0.09";

        // when
        String actualPriceInDollars = dollar.convert(priceInPennies);

        // then
        assertEquals(expectedPriceInDollars, actualPriceInDollars);
    }

    @Test
    public void convertZero() throws Exception {
        // given
        int priceInPennies = 0;
        String expectedPriceInDollars = "0.00";

        // when
        String actualPriceInDollars = dollar.convert(priceInPennies);

        // then
        assertEquals(expectedPriceInDollars, actualPriceInDollars);
    }

}