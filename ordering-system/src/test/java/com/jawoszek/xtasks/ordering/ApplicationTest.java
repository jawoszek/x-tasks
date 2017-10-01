package com.jawoszek.xtasks.ordering;

import com.jawoszek.xtasks.ordering.console.Console;
import com.jawoszek.xtasks.ordering.food.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.String.format;
import static java.util.Arrays.stream;

/**
 * @author Kacper
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

    private static final String ZERO_PRICE = "0.00$";
    private static final String ONE_LUNCH_PRICE = "12.99$";

    @Mock
    private PrintStream mockPrintStream;

    @Test
    public void startWithImmediateExit() {
        // given
        Scanner scanner = new Scanner(getInputStream("2"));
        Console console = new Console(mockPrintStream, scanner);
        Menu menu = Menu.standardMenu();
        LinesVerifier verifier = new LinesVerifier(mockPrintStream);

        // when
        new Application().start(console, menu);

        // then
        verifier.expectNewOrder();
        verifier.verifyExpectedLinesInOutput();
    }

    @Test
    public void startWithEmptyCancelledOrder() {
        // given
        Scanner scanner = new Scanner(getInputStream(controlSequence(0, 3, 0, 2)));
        Console console = new Console(mockPrintStream, scanner);
        Menu menu = Menu.standardMenu();
        LinesVerifier verifier = new LinesVerifier(mockPrintStream);

        // when
        new Application().start(console, menu);

        // then
        verifier.expectNewOrder();
        verifier.expectOrderControl(ZERO_PRICE);
        verifier.expectCancelOrder(ZERO_PRICE);
        verifier.expectNewOrder();
        verifier.verifyExpectedLinesInOutput();
    }

    @Test
    public void startWithSingleLunchAccepted() {
        Scanner scanner = new Scanner(getInputStream(controlSequence(0, 1, 0, 0, 2, 0, 2)));
        Console console = new Console(mockPrintStream, scanner);
        Menu menu = Menu.standardMenu();
        LinesVerifier verifier = new LinesVerifier(mockPrintStream);

        // when
        new Application().start(console, menu);

        // then
        verifier.expectNewOrder();
        verifier.expectOrderControl(ZERO_PRICE);
        verifier.expectModifyOrder(ZERO_PRICE);
        verifier.expectAddLunch(ZERO_PRICE);
        verifier.expectOrderControl(ONE_LUNCH_PRICE);
        verifier.expectAcceptOrder(ONE_LUNCH_PRICE);
        verifier.expectNewOrder();
        verifier.verifyExpectedLinesInOutput();
    }

    private String controlSequence(int... actions) {
        return stream(actions)
                .mapToObj(Integer::toString)
                .collect(Collectors.joining(format("%n")));
    }

    private InputStream getInputStream(String content) {
        return new ByteArrayInputStream(content.getBytes());
    }

}