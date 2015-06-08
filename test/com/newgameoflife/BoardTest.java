package com.newgameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BoardTest {

    Board board;

    @Before
    public void setUp() {
        board = new Board(2, 2);
    }

    @Test
    public void shouldPrintStateOfTheBoardWithOnlyDeadCells() {
        String expected = "0 0 \n" +
                "0 0 \n";

        String actualString = board.toString();

        assertEquals(expected, actualString);
    }

}