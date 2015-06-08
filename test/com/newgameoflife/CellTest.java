package com.newgameoflife;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {

    Cell cell;

    @Before
    public void setUp() {
        cell = new Cell();
    }

    @Test
    public void shouldToggleStateIfStateIsFalse() {
        cell.toggleState();

        assertTrue(cell.isAlive());
    }

    @Test
    public void shouldToggleStateIfStateIsTrue() {
        cell.toggleState();

        cell.toggleState();

        assertFalse(cell.isAlive());
    }

    @Test
    public void shouldReturnStateAsStringIfStateIsDead() {
        String actuatString = cell.toString();
        assertEquals("0", actuatString);
    }

}