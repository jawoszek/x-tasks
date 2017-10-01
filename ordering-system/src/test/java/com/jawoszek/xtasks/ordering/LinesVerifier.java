package com.jawoszek.xtasks.ordering;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.mockito.Mockito.*;

/**
 * @author Kacper
 */
public class LinesVerifier {

    private static final String PRICE_HEADER_FORMAT = "=== Current order price: %s ===";
    private static final String MAIN_MENU =
            format("%s%n%s%n%s", "0 - Create new order", "1 - Show menu", "2 - Exit application");
    private static final String ORDER_MENU =
            format("%s%n%s%n%s%n%s", "0 - Show order", "1 - Modify order", "2 - Accept order", "3 - Cancel order");
    private static final String MODIFY_MENU =
            format("%s%n%s%n%s%n%s", "0 - Add lunch", "1 - Add drink", "2 - Remove lunch", "3 - Remove drink");
    private static final String LUNCH_MENU = of(
            "0 - Main dish:pork chop with potatoes   Dessert:apple pie   Price:12.99$",
            "1 - Main dish:ruthenian pierogi   Dessert:apple pie   Price:10.99$",
            "2 - Main dish:nachos   Dessert:chocolate cake   Price:15.99$",
            "3 - Main dish:tacos with pork and cheese   Dessert:chocolate cake   Price:13.99$",
            "4 - Main dish:pizza margherita   Dessert:chocolate cake   Price:18.99$",
            "5 - Main dish:farfalle with tomato sauce   Dessert:chocolate cake   Price:12.99$"
    ).collect(Collectors.joining(format("%n")));
    private static final String OPTIONS_HEADER = format("%nPossible options:");
    private static final String CONTINUE_MENU = "0 - Continue";
    private static final String OPTIONS_REQUEST = "Please choose valid number from options above";
    private static final String CLEAR_SCREEN = format("%n%n%n");
    private static final String CANCELLED = "Order cancelled";
    private static final String ACCEPTED = "Order accepted";
    private static final String MAIN_MENU_HEADER = "Welcome to ordering system!";

    private final Map<String, Integer> expectedLines = new HashMap<>();
    private final PrintStream mockPrintStream;

    public LinesVerifier(PrintStream mockPrintStream) {
        this.mockPrintStream = mockPrintStream;
    }

    public void expectNewOrder() {
        of(MAIN_MENU_HEADER, OPTIONS_HEADER, MAIN_MENU, OPTIONS_REQUEST, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectOrderControl(String price) {
        of(priceLine(price), OPTIONS_HEADER, ORDER_MENU, OPTIONS_REQUEST, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectCancelOrder(String price) {
        of(priceLine(price), OPTIONS_HEADER, CONTINUE_MENU, OPTIONS_REQUEST, CANCELLED, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectModifyOrder(String price) {
        of(priceLine(price), OPTIONS_HEADER, MODIFY_MENU, OPTIONS_REQUEST, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectAddLunch(String price) {
        of(priceLine(price), OPTIONS_HEADER, LUNCH_MENU, OPTIONS_REQUEST, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectAcceptOrder(String price) {
        of(priceLine(price), OPTIONS_HEADER, CONTINUE_MENU, OPTIONS_REQUEST, ACCEPTED, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void verifyExpectedLinesInOutput() {
        expectedLines.forEach((line, count) -> verify(mockPrintStream, times(count)).println(line));
        verifyNoMoreInteractions(mockPrintStream);
    }

    private void expectLine(String line) {
        expectedLines.merge(line, 1, (old, added) -> old + added);
    }

    private String priceLine(String price) {
        return format(PRICE_HEADER_FORMAT, price);
    }
}
