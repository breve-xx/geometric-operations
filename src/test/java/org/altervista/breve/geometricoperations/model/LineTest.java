package org.altervista.breve.geometricoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class LineTest {
    
    @Test
    public void testOfDoubleDouble() {

        final Line l = Line.of(1, 0);

        assertEquals(1, l.getSlope());
        assertEquals(0, l.getYIntercepts());
    }

    @Test
    public void testOfPointPoint() {

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