package org.altervista.breve.geometricoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PointTest {
    
	@Test
    public void testOfDoubleDouble() {
        
        final Point p = Point.of(1, 10);

        assertEquals(1, p.getX());
        assertEquals(10, p.getY());
    }

    @Test
    public void testEqualsAndHashcode() {

        final Point p1 = Point.of(1, 10);

        final Point p2 = Point.of(1, 10);
        assertEquals(p1.hashCode(), p2.hashCode());
        assertTrue(p1.equals(p2));
        assertTrue(p2.equals(p1));

        final Point p3 = Point.of(-1, 10);
        assertNotEquals(p1.hashCode(), p3.hashCode());
        assertFalse(p1.equals(p3));
        assertFalse(p3.equals(p1));
    }
}