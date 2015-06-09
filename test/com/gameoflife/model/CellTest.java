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
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    public void shouldVerifyEqualsContract() {
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

    @Test
    public void shouldPrintOneWhenStateOfCellIsAlive() {
        cell = new Cell(true, neighbours);

        assertEquals("1", cell.toString());
    }

    @Test
    public void shouldBeDeadIfAliveNeighboursAreLessThanTwo() {
        neighbours = new HashSet<>();
        neighbours.add(new Cell(false, new HashSet<>()));
        neighbours.add(new Cell(false, new HashSet<>()));
        neighbours.add(new Cell(false, new HashSet<>()));
        cell = new Cell(true, neighbours);

        cell.update();

        assertFalse(cell.isAlive());
    }

    @Test
    public void shouldBeDeadIfAliveNeighboursAreMoreThanThree() {
        neighbours = new HashSet<>();
        neighbours.add(new Cell(true, new HashSet<>()));
        neighbours.add(new Cell(true, new HashSet<>()));
        neighbours.add(new Cell(true, new HashSet<>()));
        neighbours.add(new Cell(true, new HashSet<>()));
        cell = new Cell(true, neighbours);

        cell.update();

        assertFalse(cell.isAlive());
    }

}