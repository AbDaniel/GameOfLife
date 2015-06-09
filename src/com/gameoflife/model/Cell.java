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

    private int aliveNeighbours() {
        return (int) neighbours.stream().filter(Cell::isAlive).count();
    }

    public void update() {
        if (alive) {
            if (aliveNeighbours() < 2) alive = false;
            else if (aliveNeighbours() > 3) alive = false;

        } else if (aliveNeighbours() == 3) alive = true;
        notifyNeighbours();
    }

    private void notifyNeighbours() {
        neighbours.forEach(Cell::update);
    }

}
