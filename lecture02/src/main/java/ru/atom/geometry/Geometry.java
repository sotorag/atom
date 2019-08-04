package ru.atom.geometry;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

/**
 *  ^ Y
 *  |
 *  |
 *  |
 *  |          X
 *  .---------->
 */

public final class Geometry {
    /**
     * Bar is a rectangle, which borders are parallel to coordinate axis
     * Like selection bar in desktop, this bar is defined by two opposite corners
     * Bar is not oriented
     * (It is not relevant, which opposite corners you choose to define bar)
     *
     * @return new Bar
     */
    public static Collider createBar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        Collider collider = new Bar();
        ((Bar) collider).setDownLeftPoint((Point)createPoint(min(firstCornerX,secondCornerX),min(firstCornerY,secondCornerY)));
        ((Bar) collider).setUpRightPoint((Point)createPoint(max(firstCornerX,secondCornerX),max(firstCornerY,secondCornerY)));
        return collider;
    }

    /**
     * 2D point
     *
     * @return new Point
     */
    public static Collider createPoint(int x, int y) {
        Collider point = new Point();
        ((Point) point).setX(x);
        ((Point) point).setY(y);
        return point;
    }
}
