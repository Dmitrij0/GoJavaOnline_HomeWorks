package com.gojavaonline3.dlenchuk.module04.distance;

/**
 * Created by Dmitrij Lenchuk on 02.06.2016.
 * Class Line
 */
public class Line {
    private final Point point1;
    private final Point point2;
    private boolean calculated = false;
    private double length;

    public Line(Point point1, Point point2) {
        this.point1 = point1;
        this.point2 = point2;
    }

    Line(int x1, int y1, int x2, int y2) {
        this.point1 = new Point(x1, y1);
        this.point2 = new Point(x2, y2);
    }

    public Point getPoint1() {
        return point1;
    }

    public Point getPoint2() {
        return point2;
    }

    public double length() {
        if (!calculated) {
            length = Math.sqrt((point2.getX() - point1.getX())*(point2.getX() - point1.getX()) +
                               (point2.getY() - point1.getY())*(point2.getY() - point1.getY()));
            calculated = true;
        }

        return length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        if (!point1.equals(line.point1)) return false;
        return point2.equals(line.point2);

    }

    @Override
    public int hashCode() {
        int result = point1.hashCode();
        result = 31 * result + point2.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Line{" +
                "A" + point1 +
                "; B" + point2 +
                "; AB = " + String.format("%.2f", length())  +
                '}';
    }
}
