package minesweeper;

/**
 * @author Kacper
 */
class Cell {

    private boolean isMine;
    private int neighboursMines;

    Cell withMine(boolean mine) {
        isMine = mine;
        return this;
    }

    Cell withOneMoreNeighbourMine() {
        neighboursMines++;
        return this;
    }

    String getTextRepresentation() {
        return isMine ? "*" : Character.toString((char) (neighboursMines + 48));
    }
}
