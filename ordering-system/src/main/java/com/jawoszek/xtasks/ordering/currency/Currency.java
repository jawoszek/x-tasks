package com.jawoszek.xtasks.ordering.currency;

/**
 * @author Kacper
 */
public interface Currency {

    String convert(int value);

    String getCurrencySymbol();
}
