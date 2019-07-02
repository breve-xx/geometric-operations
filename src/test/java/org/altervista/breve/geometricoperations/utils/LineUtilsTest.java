package org.altervista.breve.geometricoperations.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.altervista.breve.geometricoperations.exception.InvalidPointException;
import org.altervista.breve.geometricoperations.model.Line;
import org.altervista.breve.geometricoperations.model.Point;
import org.junit.jupiter.api.Test;

public class LineUtilsTest {
    
    @Test
    public void testParallelNull() throws InvalidPointException {

        final Line l = Line.of(Point.of(-1, 0), Point.of(0, 1));

        assertFalse(LineUtils.parallel(l, null));
        assertFalse(LineUtils.parallel(null, l));
    }

    @Test
    public void testParallel() throws InvalidPointException {
        
        final Line l1 = Line.of(Point.of(-1, 0), Point.of(0, 1));

        final Line l4 = Line.of(Point.of(0, -2), Point.of(2, 0));
        assertTrue(LineUtils.parallel(l1, l4));

        final Line l3 = Line.of(Point.of(0, -3), Point.of(1, -1));
        assertFalse(LineUtils.parallel(l1, l3));
    }

    @Test
    public void testParallelHorizontal() throws InvalidPointException {
        
        final Line l1 = Line.of(Point.of(-4, 5), Point.of(4, 5));
        
        final Line l2 = Line.of(0, -5);
        assertTrue(LineUtils.parallel(l1, l2));

        final Line l3 = Line.of(Point.of(5, -5), Point.of(5, 5));
        assertFalse(LineUtils.parallel(l1, l3));
    }

    @Test
    public void testParallelVertical() throws InvalidPointException {
        
        final Line l1 = Line.of(Point.of(5, -5), Point.of(5, 5));
        
        final Line l2 = Line.of(2.4, -5);
        assertFalse(LineUtils.parallel(l1, l2));

        final Line l3 = Line.of(Point.of(0, -5), Point.of(0, 5));
        assertTrue(LineUtils.parallel(l1, l3));
    }

    @Test
    public void testPerpendicularNull() throws InvalidPointException {

        final Line l = Line.of(Point.of(-1, 0), Point.of(0, 1));

        assertFalse(LineUtils.perpendicular(l, null));
        assertFalse(LineUtils.perpendicular(null, l));
    }

    @Test
    public void testPerpendicular() throws InvalidPointException {
        
        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));

        final Line l2 = Line.of(Point.of(-1, 1), Point.of(1, -1));
        assertTrue(LineUtils.perpendicular(l1, l2));

        final Line l3 = Line.of(Point.of(0, -3), Point.of(1, -1));
        assertFalse(LineUtils.perpendicular(l1, l3));

        final Line l4 = Line.of(Point.of(5, -5), Point.of(5, 5));
        assertFalse(LineUtils.perpendicular(l1, l4));
        assertFalse(LineUtils.perpendicular(l4, l1));

        final Line l5 = Line.of(Point.of(-4, 5), Point.of(4, 5));
        assertFalse(LineUtils.perpendicular(l1, l5));
        assertFalse(LineUtils.perpendicular(l5, l1));
    }

    @Test
    public void testPerpendicularHorizontal() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(-4, 5), Point.of(4, 5));

        final Line l2 = Line.of(0, -5);
        assertFalse(LineUtils.perpendicular(l1, l2));
        assertFalse(LineUtils.perpendicular(l2, l1));

        final Line l3 = Line.of(Point.of(0, -5), Point.of(0, 5));
        assertTrue(LineUtils.perpendicular(l1, l3));
        assertTrue(LineUtils.perpendicular(l3, l1));
    }

    @Test
    public void testPerpendicularVertical() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(5, -5), Point.of(5, 5));

        final Line l2 = Line.of(Point.of(0, -5), Point.of(0, 5));
        assertFalse(LineUtils.perpendicular(l1, l2));
        assertFalse(LineUtils.perpendicular(l2, l1));

        final Line l3 = Line.of(0, -5);
        assertTrue(LineUtils.perpendicular(l1, l3));
        assertTrue(LineUtils.perpendicular(l3, l1));
    }

    @Test
    public void testIntersectionNull() throws InvalidPointException {

        final Line l = Line.of(Point.of(-1, 0), Point.of(0, 1));

        assertNull(LineUtils.intersection(l, null));
        assertNull(LineUtils.intersection(null, l));
    }

    @Test
    public void testIntersection() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));
        final Line l2 = Line.of(Point.of(-1, 1), Point.of(1, -1));

        assertEquals(Point.of(0, 0), LineUtils.intersection(l1, l2));
    }

    @Test
    public void testIntersectionVertical() throws InvalidPointException {

        final Line l1 = Line.of(Point.of(12, 1), Point.of(12, -1));
        final Line l2 = Line.of(3, -3);

        assertEquals(Point.of(12, 33), LineUtils.intersection(l1, l2));
        assertEquals(Point.of(12, 33), LineUtils.intersection(l2, l1));
    }
}