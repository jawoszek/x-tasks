package com.jawoszek.xtasks.ordering;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static java.util.stream.Stream.of;
import static org.mockito.Mockito.*;

/**
 * @author Kacper
 */
public class LinesVerifier {

    private static final String ZERO_PRICE_HEADER = "=== Current order price: 0.00$ ===";
    private static final String MAIN_MENU =
            format("%s%n%s%n%s", "0 - Create new order", "1 - Show menu", "2 - Exit application");
    private static final String ORDER_MENU =
            format("%s%n%s%n%s%n%s", "0 - Show order", "1 - Modify order", "2 - Accept order", "3 - Cancel order");
    private static final String OPTIONS_HEADER = format("%nPossible options:");
    private static final String CONTINUE_MENU = "0 - Continue";
    private static final String OPTIONS_REQUEST = "Please choose valid number from options above";
    private static final String CLEAR_SCREEN = format("%n%n%n");
    private static final String CANCELLED = "Order cancelled";
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

    public void expectOrderControl() {
        of(ZERO_PRICE_HEADER, OPTIONS_HEADER, ORDER_MENU, OPTIONS_REQUEST, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void expectCancelOrder() {
        of(ZERO_PRICE_HEADER, OPTIONS_HEADER, CONTINUE_MENU, OPTIONS_REQUEST, CANCELLED, CLEAR_SCREEN)
                .forEach(this::expectLine);
    }

    public void verifyExpectedLinesInOutput() {
        expectedLines.forEach((line, count) -> verify(mockPrintStream, times(count)).println(line));
        verifyNoMoreInteractions(mockPrintStream);
    }

    private void expectLine(String line) {
        expectedLines.merge(line, 1, (old, added) -> old + added);
    }
}
