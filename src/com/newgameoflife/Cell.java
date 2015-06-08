package com.newgameoflife;

public class Cell {

    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public boolean toggleState() {
        alive = !alive;
        return alive;
    }
}
