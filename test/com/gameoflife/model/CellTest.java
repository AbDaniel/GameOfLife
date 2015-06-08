package com.gameoflife.model;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashSet;
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
    public void shouldReturnZeroWhenNoNeighboursAreAlive() {
        neighbours = new HashSet<>();
        neighbours.add(new Cell(false, new HashSet<Cell>()));
        neighbours.add(new Cell(false, new HashSet<Cell>()));
        neighbours.add(new Cell(false, new HashSet<Cell>()));

        cell = new Cell(false, neighbours);
        int actualAliveNeighbours = cell.aliveNeighbours();

        assertEquals(0, actualAliveNeighbours);
    }

}