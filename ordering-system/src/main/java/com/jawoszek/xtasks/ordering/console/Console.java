package com.jawoszek.xtasks.ordering.console;

import java.io.PrintStream;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.util.Collections.nCopies;
import static java.util.Optional.ofNullable;

/**
 * @author Kacper
 */
public class Console {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String KEY_VALUE_SEPARATOR = " - ";
    private static final String PRE_INPUT_MESSAGE = "Please choose valid number from options above";
    private static final String NOT_A_NUMBER_MESSAGE = "Not a number!";
    private static final String CLEAR_SCREEN_SEQUENCE = on(LINE_SEPARATOR).join(nCopies(4, LINE_SEPARATOR));

    private final PrintStream out;
    private final Scanner in;

    public Console(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    public void printMessage(String message) {
        out.println(message);
    }

    public void printOptions(Map<Integer, String> options) {
        String textToPrint =
                on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(options);
        out.println(textToPrint);
    }

    public Optional<Integer> getNumberFromInput() {
        out.println(PRE_INPUT_MESSAGE);
        String line = in.nextLine();
        Integer output = null;

        try {
            output = Integer.parseInt(line);
        } catch (NumberFormatException e) {
            out.println(NOT_A_NUMBER_MESSAGE);
        }

        return ofNullable(output);
    }

    public void clearScreen(){
        out.print(CLEAR_SCREEN_SEQUENCE);
    }

    public static Console standardConsole() {
        return new Console(
                System.out,
                new Scanner(System.in));
    }

    public void close() {
        out.close();
        in.close();
    }
}
