package minesweeper;

import com.google.common.base.Stopwatch;

/**
 * @author Kacper
 */
public class Test {
    private static final int OUTER_TIMES = 10;
    private static final int TIMES = 1000000;
    private static final String FIELD = "*...\n..*.\n....";

    public static void main(String[] args) {
        for (int i = 0; i < OUTER_TIMES; i++) {
            testImpl(TIMES, FIELD);
            testImplementation(TIMES, FIELD);
        }
    }

    private static void testImpl(int times, String field) {
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        for (int i = 0; i < times; i++) {
            MineSweeper mineSweeper = new MineSweeperImpl();
            stopwatch.start();
            mineSweeper.setMineField(field);
            mineSweeper.getHintField();
            stopwatch.stop();
        }
        System.out.println("Impl:" + stopwatch);
    }

    private static void testImplementation(int times, String field) {
        Stopwatch stopwatch = Stopwatch.createUnstarted();
        for (int i = 0; i < times; i++) {
            MineSweeper mineSweeper = new MineSweeperImplementation();
            stopwatch.start();
            mineSweeper.setMineField(field);
            mineSweeper.getHintField();
            stopwatch.stop();
        }
        System.out.println("Implementation:" + stopwatch);
    }
}
