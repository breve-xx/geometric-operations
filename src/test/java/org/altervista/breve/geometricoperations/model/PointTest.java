package org.altervista.breve.geometricoperations.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PointTest {
    
    public void testOfDoubleDouble() {
        
        final Point p = Point.of(1, 10);

        assertEquals(1, p.getX());
        assertEquals(10, p.getY());
    }
}