package com.gameoflife.model;

import java.util.ArrayList;

public class Cell {

    private boolean alive;
    private ArrayList<Cell> neigbhours;

    public Cell(ArrayList<Cell> neighbours) {
        this.neigbhours = neighbours;
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean toggleState() {
        alive = !alive;
        return alive;
    }

    @Override
    public String toString() {
        return alive ? "1" : "0";
    }

    public void addNeighbours(Cell cell) {

    }

}
