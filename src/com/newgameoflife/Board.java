package com.newgameoflife;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<List<Cell>> cells;

    public Board(List<List<Cell>> cells) {
        this.cells = cells;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (List<Cell> column : cells) {
            for (Cell cell : column) {
                builder.append(cell.toString());
                builder.append(" ");
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
