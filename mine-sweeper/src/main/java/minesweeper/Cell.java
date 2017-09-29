package minesweeper;

/**
 * @author Kacper
 */
public class Cell {

    private boolean isMine;
    private int neighboursMines;

    public boolean isMine() {
        return isMine;
    }

    public int getNeighboursMines() {
        return neighboursMines;
    }

    public void setMine(boolean mine) {
        isMine = mine;
    }

    public void setNeighboursMines(int neighboursMines) {
        this.neighboursMines = neighboursMines;
    }

    public Cell withMine(boolean mine) {
        isMine = mine;
        return this;
    }

    public Cell withOneMoreNeighbourMine() {
        neighboursMines++;
        return this;
    }

    public void addNeighbourMine() {
        neighboursMines++;
    }

    public String getTextRepresentation() {
        return isMine ? "*" : Character.toString((char) (neighboursMines + 48));
    }
}
