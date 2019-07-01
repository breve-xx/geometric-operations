package org.altervista.breve.geometricoperations.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Point {
    
    private double x;
    private double y;

    public static Point of(final double x, final double y) {
        final Point p = new Point();

        p.x = x;
        p.y = y;

        return p;
    }
}