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

/**
 * @author Kacper
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

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
        Scanner scanner = new Scanner(getInputStream("0\n3\n0\n2"));
        Console console = new Console(mockPrintStream, scanner);
        Menu menu = Menu.standardMenu();
        LinesVerifier verifier = new LinesVerifier(mockPrintStream);

        // when
        new Application().start(console, menu);

        // then
        verifier.expectNewOrder();
        verifier.expectOrderControl();
        verifier.expectCancelOrder();
        verifier.expectNewOrder();
        verifier.verifyExpectedLinesInOutput();
    }

    private InputStream getInputStream(String content) {
        return new ByteArrayInputStream(content.getBytes());
    }

}