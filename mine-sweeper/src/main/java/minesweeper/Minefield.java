package minesweeper;

import com.google.common.collect.ImmutableList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Kacper
 */
class Minefield {

    private final int rowsCount;
    private final int columnsCount;
    private final Map<Coordinates, Cell> field = new HashMap<>();

    Minefield(int rowsCount, int columnsCount) {
        this.rowsCount = rowsCount;
        this.columnsCount = columnsCount;
    }

    void addMine(int row, int column) {
        Coordinates mineCoordinates = new Coordinates(row, column);
        setMineAt(mineCoordinates);

        mineCoordinates
                .getSurrounding()
                .forEach(this::addNeighbourToCell);
    }

    private void setMineAt(Coordinates coordinates) {
        field.merge(
                coordinates,
                new Cell().withMine(true),
                (previous, added) -> previous.withMine(true)
        );
    }

    String getTextRepresentation() {
        return IntStream
                .range(0, rowsCount)
                .mapToObj(this::getRowAsText)
                .collect(Collectors.joining("\n"));
    }

    private String getRowAsText(int row) {
        return IntStream
                .range(0, columnsCount)
                .mapToObj(column -> new Coordinates(row, column))
                .map(field::get)
                .map(cell -> cell != null ? cell.getTextRepresentation() : "0")
                .collect(Collectors.joining());
    }

    private void addNeighbourToCell(Coordinates coordinates) {
        field.merge(
                coordinates,
                new Cell().withOneMoreNeighbourMine(),
                (old, added) -> old.withOneMoreNeighbourMine()
        );
    }


    private static class Coordinates {

        private final int row;
        private final int column;

        Coordinates(int row, int column) {
            this.row = row;
            this.column = column;
        }

        List<Coordinates> getSurrounding() {
            return ImmutableList.of(
                    new Coordinates(row + 1, column + 1),
                    new Coordinates(row + 1, column),
                    new Coordinates(row, column + 1),
                    new Coordinates(row - 1, column - 1),
                    new Coordinates(row - 1, column),
                    new Coordinates(row, column - 1),
                    new Coordinates(row + 1, column - 1),
                    new Coordinates(row - 1, column + 1)
            );
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Coordinates that = (Coordinates) o;

            return Objects.equals(row, that.row) && Objects.equals(column, that.column);
        }

        @Override
        public int hashCode() {
            return Objects.hash(row, column);
        }
    }
}
