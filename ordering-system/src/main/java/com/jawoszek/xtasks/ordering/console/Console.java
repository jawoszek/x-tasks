package com.jawoszek.xtasks.ordering.console;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import static com.google.common.base.Joiner.on;
import static java.util.Collections.nCopies;

/**
 * @author Kacper
 */
public class Console {

    public static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String KEY_VALUE_SEPARATOR = " - ";
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

    public int getNumberFromInput() {
        out.println("Please choose valid number from options above");
        String line = in.nextLine();
        try {
            return Integer.parseInt(line);
        } catch (NumberFormatException e) {
            out.println("Not a number!");
        }
        return -1;
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
