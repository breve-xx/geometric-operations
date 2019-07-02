package org.altervista.breve.geometricoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.altervista.breve.geometricoperations.exception.InvalidPointException;
import org.junit.jupiter.api.Test;

public class LineTest {
    
    @Test
    public void testOfDoubleDouble() {

        final Line l1 = Line.of(1, 0);

        assertFalse(l1.isHorizontal());
        assertFalse(l1.isVertical());
        
        assertEquals(1, l1.getSlope());
        assertEquals(0, l1.getYIntercepts());
        
        final Line l2 = Line.of(0, 2);

        assertTrue(l2.isHorizontal());
        assertFalse(l2.isVertical());
        
        assertEquals(0, l2.getSlope());
        assertEquals(2, l2.getYIntercepts());
    }

    @Test
    public void testOfPointPoint() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));

        assertEquals(1, l1.getSlope());
        assertEquals(0, l1.getYIntercepts());

        final Line l2 = Line.of(Point.of(0, -2), Point.of(2, 0));

        assertEquals(1, l2.getSlope());
        assertEquals(-2, l2.getYIntercepts());

        final Line l3 = Line.of(Point.of(-1, 0), Point.of(0, 1));

        assertEquals(1, l3.getSlope());
        assertEquals(1, l3.getYIntercepts());
    }
}