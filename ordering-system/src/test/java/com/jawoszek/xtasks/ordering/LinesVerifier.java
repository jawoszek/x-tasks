package com.jawoszek.xtasks.ordering;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
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
    private static final String CONTINUE_MENU = "0 - Continue";
    private static final String OPTIONS_REQUEST = "Please choose valid number from options above";
    private static final String CLEAR_SCREEN = format("%n%n%n");
    private static final String CANCELLED = "Order cancelled";

    private final Map<String, Integer> expectedLines = new HashMap<>();
    private final PrintStream mockPrintStream;

    public LinesVerifier(PrintStream mockPrintStream) {
        this.mockPrintStream = mockPrintStream;
    }

    public void expectNewOrder() {
        expectLine(ZERO_PRICE_HEADER);
        expectLine(MAIN_MENU);
        expectLine(OPTIONS_REQUEST);
        expectLine(CLEAR_SCREEN);
    }

    public void expectOrderControl() {
        expectLine(ZERO_PRICE_HEADER);
        expectLine(ORDER_MENU);
        expectLine(OPTIONS_REQUEST);
        expectLine(CLEAR_SCREEN);
    }

    public void expectCancelOrder() {
        expectLine(ZERO_PRICE_HEADER);
        expectLine(CONTINUE_MENU);
        expectLine(OPTIONS_REQUEST);
        expectLine(CANCELLED);
        expectLine(CLEAR_SCREEN);
    }

    public void verifyExpectedLinesInOutput() {
        expectedLines.forEach((line, count) -> verify(mockPrintStream, times(count)).println(line));
        verifyNoMoreInteractions(mockPrintStream);
    }

    private void expectLine(String line) {
        expectedLines.merge(line, 1, (old, added) -> old + added);
    }
}
