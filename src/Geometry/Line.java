package Geometry;

public class Line {
    Point start;
    Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point getStart() { return start; }
    public Point getEnd() { return end; }
    public void setStart(Point start) { this.start = start; }
    public void setEnd(Point end) { this.end = end; }

    @Override
    public String toString() { return "Линия от " + start + " до " + end; }
}
