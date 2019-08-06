package ru.atom.geometry;

import static java.lang.Integer.max;
import static java.lang.Integer.min;

public class Bar implements Collider {
    private Point downLeftPoint;
    private Point upRightPoint;

    public Bar(int firstCornerX, int firstCornerY, int secondCornerX, int secondCornerY) {
        this.downLeftPoint = new Point(min(firstCornerX,secondCornerX),min(firstCornerY,secondCornerY));
        this.upRightPoint = new Point(max(firstCornerX,secondCornerX),max(firstCornerY,secondCornerY));
    }

    @Override
    public boolean isColliding(Collider other) {
        if (this.equals(other))
            return true;
        if (other instanceof Bar) {
            Bar bar = (Bar) other;
            if (this.upRightPoint.getX() >= bar.downLeftPoint.getX()
                    && this.downLeftPoint.getX() <= bar.upRightPoint.getX()
                    && this.upRightPoint.getY() >= bar.downLeftPoint.getY()
                    && this.downLeftPoint.getY() <= bar.upRightPoint.getY())
                return true;
            else return false;
        } else {
            Point point = (Point) other;
            if (this.downLeftPoint.getX() <= point.getX()
                    && this.upRightPoint.getX() >= point.getX()
                    && this.downLeftPoint.getY() <= point.getY()
                    && this.upRightPoint.getY() >= point.getY())
                return true;
            else return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bar bar = (Bar) o;

        if (this. downLeftPoint.equals(bar. downLeftPoint) && this.upRightPoint.equals(bar.upRightPoint))
            return true;
        else return false;

    }
}
