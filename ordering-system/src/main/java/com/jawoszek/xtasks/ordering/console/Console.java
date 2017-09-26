package com.jawoszek.xtasks.ordering.console;

import com.google.common.base.Joiner;

import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kacper
 */
public class Console {

    private static final String LINE_SEPARATOR = System.lineSeparator();
    private static final String KEY_VALUE_SEPARATOR = " - ";

    private final PrintStream out;
    private final Scanner in;

    public Console(PrintStream out, Scanner in) {
        this.out = out;
        this.in = in;
    }

    public void printOptions(Map<Integer, String> options) {
        String textToPrint = Joiner
                .on(LINE_SEPARATOR)
                .withKeyValueSeparator(KEY_VALUE_SEPARATOR)
                .join(options);
        out.println(textToPrint);
    }

    public int getNumberFromInput() {
        String line = in.nextLine();
        return Integer.parseInt(line);
    }

    public static Console standardConsole() {
        return new Console(
                System.out,
                new Scanner(System.in));
    }

    public void close(){
        out.close();
        in.close();
    }
}
