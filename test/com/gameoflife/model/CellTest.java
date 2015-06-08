package com.gameoflife.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CellTest {

    Cell cell;

    @Mock
    Set<Cell> neighbours;

    @Before
    public void setUp() {
        cell = new Cell(neighbours);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Cell.class).usingGetClass();
    }

    @Test
    public void shouldToggleStateIfStateIsDead() {
        cell.toggleState();

        assertTrue(cell.isAlive());
    }

    @Test
    public void shouldToggleStateIfStateIsAlive() {
        cell.toggleState();

        cell.toggleState();

        assertFalse(cell.isAlive());
    }

    @Test
    public void shouldReturnStateAsStringIfStateIsDead() {
        String actuatString = cell.toString();

        assertEquals("0", actuatString);
    }

    @Test
    public void shouldReturnStateAsStringIfStateIsAlive() {
        cell.toggleState();

        String actualString = cell.toString();

        assertEquals("1", actualString);
    }

    @Test
    public void shouldAddNeighbour() {
        cell.addNeighbours(cell);

        Mockito.verify(neighbours).add(cell);
    }

}