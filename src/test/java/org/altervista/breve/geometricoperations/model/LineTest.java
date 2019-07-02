package org.altervista.breve.geometricoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

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

        assertNull(l1.getXIntercepts());
        
        final Line l2 = Line.of(0, 2);

        assertTrue(l2.isHorizontal());
        assertFalse(l2.isVertical());
        
        assertEquals(0, l2.getSlope());
        assertEquals(2, l2.getYIntercepts());
        
        assertNull(l2.getXIntercepts());
    }

    @Test
    public void testOfPointPointErrors() throws InvalidPointException {

        final Point p = Point.of(10, 10);

        try {
            Line.of(null, p);
            fail();
        } catch(NullPointerException ignored) {}

        try {
            Line.of(p, null);
            fail();
        } catch(NullPointerException ignored) {}

        try {
            Line.of(p, p);
            fail();
        } catch(InvalidPointException ignored) {}

    }

    @Test
    public void testOfPointPoint() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));

        assertEquals(1, l1.getSlope());
        assertEquals(0, l1.getYIntercepts());
        assertFalse(l1.isHorizontal());
        assertFalse(l1.isVertical());
        assertNull(l1.getXIntercepts());

        final Line l2 = Line.of(Point.of(0, -2), Point.of(2, 0));

        assertEquals(1, l2.getSlope());
        assertEquals(-2, l2.getYIntercepts());
        assertFalse(l2.isHorizontal());
        assertFalse(l2.isVertical());
        assertNull(l2.getXIntercepts());

        final Line l3 = Line.of(Point.of(-1, 0), Point.of(0, 1));

        assertEquals(1, l3.getSlope());
        assertEquals(1, l3.getYIntercepts());
        assertFalse(l3.isHorizontal());
        assertFalse(l3.isVertical());
        assertNull(l3.getXIntercepts());

        final Line l4 = Line.of(Point.of(5, -5), Point.of(5, 5));

        assertNull(l4.getSlope());
        assertNull(l4.getYIntercepts());
        assertFalse(l4.isHorizontal());
        assertTrue(l4.isVertical());
        assertEquals(5, l4.getXIntercepts());

        final Line l5 = Line.of(Point.of(-4, 5), Point.of(4, 5));

        assertEquals(0, l5.getSlope());
        assertEquals(5, l5.getYIntercepts());
        assertTrue(l5.isHorizontal());
        assertFalse(l5.isVertical());
        assertNull(l5.getXIntercepts());
    }
}