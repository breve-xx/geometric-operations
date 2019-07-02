package org.altervista.breve.geometricoperations.model;

import java.util.Objects;

import org.altervista.breve.geometricoperations.exception.InvalidPointException;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Line {

	private boolean horizontal;
	private boolean vertical;
	
    private Double slope;
    private Double yIntercepts;

    public static Line of(final double slope, final double yIntercepts) {
        final Line l = new Line();

        l.horizontal = slope == 0;
        
        l.slope = slope;
        l.yIntercepts = yIntercepts;

        return l;
    }

    public static Line of(final Point p1, final Point p2) throws InvalidPointException {
        
        Objects.requireNonNull(p1, "You can't define a line for a null point!");
        Objects.requireNonNull(p2, "You can't define a line for a null point!");
        
        if(Objects.equals(p1, p2)) throw new InvalidPointException("You can't define a line for a signle point!");
        
        final Line l = new Line();

        l.vertical = Objects.equals(p1.getX(), p2.getX());
        
        if(!l.vertical) {
        	l.horizontal = Objects.equals(p1.getY(), p2.getY());
        	
        	l.slope = (p1.getY() - p2.getY()) / (p1.getX() - p2.getX()) + 0.0; // + 0.0 is needed to avoid the -0.0 double problem.
            l.yIntercepts = p1.getY() - p1.getX() * l.slope;
        }
        
        return l;
    }
}