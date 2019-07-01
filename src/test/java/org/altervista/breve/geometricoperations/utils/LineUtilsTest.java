package org.altervista.breve.geometricoperations.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.altervista.breve.geometricoperations.model.Line;
import org.altervista.breve.geometricoperations.model.Point;
import org.junit.jupiter.api.Test;

public class LineUtilsTest {
    
    @Test
    public void testParallel() {
        
        final Line l1 = Line.of(Point.of(-1, 0), Point.of(0, 1));

        final Line l4 = Line.of(Point.of(0, -2), Point.of(2, 0));
        assertTrue(LineUtils.parallel(l1, l4));

        final Line l3 = Line.of(Point.of(0, -3), Point.of(1, -1));
        assertFalse(LineUtils.parallel(l1, l3));
    }

    @Test
    public void testPerpendicular() {
        
        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));

        final Line l2 = Line.of(Point.of(-1, 1), Point.of(1, -1));
        assertTrue(LineUtils.perpendicular(l1, l2));

        final Line l3 = Line.of(Point.of(0, -3), Point.of(1, -1));
        assertFalse(LineUtils.perpendicular(l1, l3));
    }

    @Test
    public void testIntersection() {

        final Line l1 = Line.of(Point.of(1, 1), Point.of(-1, -1));
        final Line l2 = Line.of(Point.of(-1, 1), Point.of(1, -1));

        assertEquals(Point.of(0, 0), LineUtils.intersection(l1, l2));
    }
}