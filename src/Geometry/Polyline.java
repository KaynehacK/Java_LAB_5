package Geometry;

import java.util.ArrayList;
import java.util.List;

public class Polyline {
    private List<Point> points;

    public Polyline(List<Point> pointsInput) {
        points = new ArrayList<Point>(pointsInput);
    }

    public List<Point> getPoints() { return points; }
    public void setPoints(List<Point> points) { this.points = points;}

    @Override
    public String toString() { return "Линия " + points; }
}
