package com.gameoflife.model;

import java.util.Set;

public class Cell {

    private boolean alive;
    private Set<Cell> neighbours;

    public Cell(boolean alive, Set<Cell> neighbours) {
        this.alive = alive;
        this.neighbours = neighbours;
    }

    public boolean isAlive() {
        return alive;
    }

    @Override
    public String toString() {
        return alive ? "1" : "0";
    }

    public void addNeighbours(Cell cell) {
        neighbours.add(cell);
    }

    public int aliveNeighbours() {
        return 0;
    }
}
