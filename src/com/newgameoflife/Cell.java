package com.newgameoflife;

public class Cell {

    private boolean alive;

    public Cell() {
        alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean toggleState() {
        alive = !alive;
        return alive;
    }
}
