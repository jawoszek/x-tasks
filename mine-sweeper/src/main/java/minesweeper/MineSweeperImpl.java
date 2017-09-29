package minesweeper;

import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * @author Kacper
 */
public class MineSweeperImpl implements MineSweeper {

    private static final String ROWS_SEPARATOR = "\n";
    private static final char MINE_CHAR = '*';
    private static final char NON_MINE_CHAR = '.';

    private String minefield;


    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        this.minefield = null;
        String[] rows = mineField.split(ROWS_SEPARATOR);

        int rowsCount = rows.length;
        if (rowsCount < 1 || rows[0].length() < 1) {
            throw new IllegalArgumentException("Field or its first row cannot be empty");
        }

        int columnsCount = rows[0].length();
        boolean allRowsHaveSameLength = stream(rows).allMatch(row -> row.length() == columnsCount);

        if (!allRowsHaveSameLength) {
            throw new IllegalArgumentException("Cannot set field with different rows length");
        }

        int[][] minefield = new int[rowsCount][columnsCount];

        iterateOverRows(minefield, rows);

        this.minefield = stream(minefield)
                .map(this::rowToLine)
                .collect(Collectors.joining(ROWS_SEPARATOR));
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (minefield == null) {
            throw new IllegalStateException("Minefield not set");
        }
        return minefield;
    }

    private void iterateOverRows(int[][] minefield, String[] rows) {
        for (int row = 0; row < minefield.length; row++) {
            iterateOverColumns(minefield, rows[row], row);
        }
    }

    private void iterateOverColumns(int[][] minefield, String row, int rowNumber) {
        for (int column = 0; column < minefield[rowNumber].length; column++) {
            processCell(minefield, row.charAt(column), rowNumber, column);
        }
    }

    private void processCell(int[][] minefield, char value, int row, int column) {
        switch (value) {
            case NON_MINE_CHAR:
                break;
            case MINE_CHAR:
                markMineIterateOverRows(minefield, row, column);
                break;
            default:
                throw new IllegalArgumentException("Illegal character in minefield");
        }
    }

    private void markMineIterateOverRows(int[][] minefield, int row, int column) {
        for (int currentRow = row - 1; currentRow <= row + 1; currentRow++) {
            if (currentRow < 0 || currentRow >= minefield.length) {
                continue;
            }
            markMineIterateOverColumns(minefield, row, column, currentRow);
        }
    }

    private void markMineIterateOverColumns(int[][] minefield, int row, int column, int currentRow) {
        for (int currentColumn = column - 1; currentColumn <= column + 1; currentColumn++) {
            if (currentColumn < 0 || currentColumn >= minefield[currentRow].length) {
                continue;
            }
            if (currentRow == row && currentColumn == column) {
                minefield[currentRow][currentColumn] += 9;
            } else {
                minefield[currentRow][currentColumn]++;
            }
        }
    }

    private String rowToLine(int[] row) {
        return stream(row)
                .boxed()
                .map(this::cellToChar)
                .collect(Collectors.joining());
    }

    private String cellToChar(int cell) {
        if (cell >= 9) {
            return Character.toString(MINE_CHAR);
        }
        return Integer.toString(cell);
    }
}
