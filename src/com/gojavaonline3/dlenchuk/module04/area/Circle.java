package com.gojavaonline3.dlenchuk.module04.area;

import com.gojavaonline3.dlenchuk.module04.distance.Point;

/**
 * Created by Dmitrij Lenchuk on 02.06.2016.
 * Class Circle
 */
public class Circle extends TwoDimensionalFigure{

    private final Point center;
    private final int radius;

    Circle(Point center, int radius) throws FigureExistenceIsImpossibleException {
        this.center = center;
        this.radius = radius;

        if (!checkExists()) {
            throw new FigureExistenceIsImpossibleException("Such circle can not be created\nCause: 'radius < 0'");
        }
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        if (!calculated) {
            area = Math.PI*radius*radius;
            calculated = true;
        }

        return area;
    }

    public boolean checkExists() {
        return radius >= 0;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "O" + center +
                ", radius=" + radius +
                '}';
    }
}
