package org.altervista.breve.geometricoperations.model;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Line {

    private double slope;
    private double yIntercepts;

    public static Line of(final double slope, final double yIntercepts) {
        final Line l = new Line();

        l.slope = slope;
        l.yIntercepts = yIntercepts;

        return l;
    }

    public static Line of(final Point p1, final Point p2) {
        final Line l = new Line();

        l.slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX());
        l.yIntercepts = p1.getY() - p1.getX() * l.slope;

        return l;
    }
}