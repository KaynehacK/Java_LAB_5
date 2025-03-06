package Geometry;

import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Point) {
            Point other = (Point)o;
            return Objects.equals(x, other.x) && Objects.equals(y, other.y);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() { return "{"+ x + ";" + y + "}"; }
}
