package com.jawoszek.xtasks.ordering.currency;

import static java.lang.String.format;

/**
 * @author Kacper
 */
public class USDollar implements Currency {

    private static final String SYMBOL = "$";

    @Override
    public String convert(int value) {
        int pennies = value % 100;
        int dollars = value / 100;

        return dollars + "." + format("%02d", pennies);
    }

    @Override
    public String getCurrencySymbol() {
        return SYMBOL;
    }
}
