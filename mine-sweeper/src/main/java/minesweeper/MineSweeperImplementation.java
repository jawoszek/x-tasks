package minesweeper;

import java.util.stream.IntStream;

import static java.util.Arrays.stream;

/**
 * @author Kacper
 */
public class MineSweeperImplementation implements MineSweeper {

    private String textRepresentation;

    @Override
    public void setMineField(String mineField) throws IllegalArgumentException {
        String[] rows = mineField.split("\n");

        Minefield minefield = constructMinefield(rows);

        iterateOverRows(minefield, rows);

        this.textRepresentation = minefield.getTextRepresentation();
    }

    @Override
    public String getHintField() throws IllegalStateException {
        if (textRepresentation == null) {
            throw new IllegalStateException("Minefield not set");
        }
        return textRepresentation;
    }

    private Minefield constructMinefield(String[] rows) {

        int rowsCount = rows.length;
        if (rowsCount < 1) {
            throw new IllegalArgumentException();
        }

        int columnsCount = rows[0].length();
        boolean allRowsHaveTheSameLength = stream(rows).allMatch(row -> row.length() == columnsCount);

        if (!allRowsHaveTheSameLength) {
            throw new IllegalArgumentException();
        }

        if (columnsCount < 1) {
            throw new IllegalArgumentException();
        }

        return new Minefield(rowsCount, columnsCount);
    }

    private void iterateOverRows(Minefield minefield, String[] rows) {
        IntStream
                .range(0, rows.length)
                .forEach(rowNumber -> iterateOverColumns(minefield, rowNumber, rows[rowNumber]));
    }

    private void iterateOverColumns(Minefield minefield, int rowNumber, String row) {
        IntStream
                .range(0, row.length())
                .forEach(columnNumber -> processSign(
                        minefield,
                        rowNumber,
                        columnNumber,
                        row.charAt(columnNumber))
                );
    }

    private void processSign(Minefield minefield, int rowNumber, int columnNumber, char sign) {
        switch (sign) {
            case '.':
                break;
            case '*':
                minefield.addMine(rowNumber, columnNumber);
                break;
            default:
                throw new IllegalArgumentException("Unknown character in field");
        }
    }

}
