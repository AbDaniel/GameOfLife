package com.gameoflife.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BoardTest {

    Board board;

    @Mock
    List<List<Cell>> cells;

    @Before
    public void setUp() {
        board = new Board(cells);
    }

    private void setUpWithData() {
        int length = 3;
        cells = new ArrayList<List<Cell>>();
        for (int i = 0; i < length; i++) {
            List<Cell> row = new ArrayList<Cell>();
            for (int j = 0; j < length; j++) {
                row.add(new Cell(new ArrayList<Cell>()));
            }
            cells.add(row);
        }
        board = new Board(cells);
    }

    @Test
    public void shouldPrintStateOfTheBoardWithOnlyDeadCells() {
        setUpWithData();
        String expected = "0 0 0 \n" +
                "0 0 0 \n" +
                "0 0 0 \n";

        String actualString = board.toString();

        assertEquals(expected, actualString);
    }

}