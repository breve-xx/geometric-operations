package org.altervista.breve.geometricoperations.utils;

import java.util.Objects;
import org.altervista.breve.geometricoperations.model.Line;
import org.altervista.breve.geometricoperations.model.Point;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LineUtils {

    public static boolean parallel(final Line l1, final Line l2) {

        if(Objects.isNull(l1) || Objects.isNull(l2)) return false;

        return Objects.equals(l1.getSlope(), l2.getSlope());
    }

    public static boolean perpendicular(final Line l1, final Line l2) {
        
        if(Objects.isNull(l1) || Objects.isNull(l2)) return false;

        return Objects.equals(l1.getSlope() / l2.getSlope(), -1.0);
    }

    public static Point intersection(final Line l1, final Line l2) {
        
        if(Objects.isNull(l1) || Objects.isNull(l2)) return null;
        if(parallel(l1, l2)) return null; // If two lines are not parallel then they intersect.

        final double x = (l2.getYIntercepts() - l1.getYIntercepts()) / (l1.getSlope() - l2.getSlope());
        final double y = YfromX(l1, x);

        return Point.of(x, y);
    }

    private static double YfromX(final Line line, final double x) {
        return x * line.getSlope() + line.getYIntercepts();
    }
}