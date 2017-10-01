package com.jawoszek.xtasks.ordering.currency;

/**
 * Classes implementing <code>Currency</code> should be used to indicate billing currency.
 *
 * @author Kacper
 */
public interface Currency {

    /**
     * Converts price value (e.g. pennies) to basic currency format (e.g. dollars).
     *
     * @param value basic price
     * @return a string representation of price
     */
    String convert(int value);

    /**
     * @return currency symbol
     */
    String getCurrencySymbol();
}
