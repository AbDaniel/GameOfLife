package com.gameoflife.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Set;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CellTest {

    Cell cell;

    @Mock
    Set<Cell> neighbours;

    @Before
    public void setUp() {
        cell = new Cell(false, neighbours);
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Cell.class).usingGetClass();
    }

    @Test
    public void shouldAddNeighbour() {
        cell.addNeighbours(cell);

        Mockito.verify(neighbours).add(cell);
    }

    @Test
    public void shouldPrintZeroWhenStateOfCellIsDead() {
        assertEquals("0", cell.toString());
    }

}