package com.newgameoflife;

import java.util.ArrayList;
import java.util.List;

public class Board {

    List<List<Cell>> cells;

    public Board(int length, int breadth) {
        cells = new ArrayList<List<Cell>>();
        for (int i = 0; i < length; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < breadth; j++) {
                row.add(new Cell());
            }
            cells.add(row);
        }
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
