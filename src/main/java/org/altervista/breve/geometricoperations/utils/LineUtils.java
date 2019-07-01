package org.altervista.breve.geometricoperations.utils;

import java.util.Objects;

import org.altervista.breve.geometricoperations.model.Line;

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
}