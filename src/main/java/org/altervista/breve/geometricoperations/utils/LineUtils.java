package org.altervista.breve.geometricoperations.utils;

import java.util.Objects;
import org.altervista.breve.geometricoperations.model.Line;
import org.altervista.breve.geometricoperations.model.Point;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineUtils {

    public static boolean parallel(final Line l1, final Line l2) {

        // Thowing exceptions is expensive... so I assume that nothing is parallel to a null line.
        if(Objects.isNull(l1) || Objects.isNull(l2)) return false;
        
        /**
         * There's no need to evaluate isHorizontal or isVertical
         * two horizontal lines are parallel -> 0 == 0
         * two vertical lines are parellel -> null == null | the only case where slope is null is the vertical line.
         */
        return Objects.equals(l1.getSlope(), l2.getSlope());
    }

    public static boolean perpendicular(final Line l1, final Line l2) {
        
        // Thowing exceptions is expensive... so I assume that nothing is perpendicular to a null line.
        if(Objects.isNull(l1) || Objects.isNull(l2)) return false;

        // l1.getSlope() can't be null
        if(l1.isVertical()) return l2.isHorizontal();
        // l2.getSlope() can't 0 or null
        if(l2.isHorizontal()) return l1.isVertical();
        if(l2.isVertical()) return l1.isHorizontal();

        return Objects.equals(l1.getSlope() / l2.getSlope(), -1.0);
    }

    public static Point intersection(final Line l1, final Line l2) {
        
        // Thowing exceptions is expensive... so I assume that dosen't exists an intersection with a null line.
        if(Objects.isNull(l1) || Objects.isNull(l2)) return null;
        if(parallel(l1, l2)) return null; // If two lines are not parallel then they intersect.

        if(l1.isVertical()) return Point.of(l1.getXIntercepts(), YfromX(l2, l1.getXIntercepts()));
        if(l2.isVertical()) return Point.of(l2.getXIntercepts(), YfromX(l1, l2.getXIntercepts()));

        final double x = (l2.getYIntercepts() - l1.getYIntercepts()) / (l1.getSlope() - l2.getSlope());
        return Point.of(x, YfromX(l1, x));
    }

    private static double YfromX(final Line line, final double x) {
        // In a private method I don't check for nulls, the caller needs to do it.
        return x * line.getSlope() + line.getYIntercepts();
    }
}