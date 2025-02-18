package ru.elizarov.geometry;

public class ClosedPolyline extends Polyline {

    public ClosedPolyline(Point[] points) {
        super(points);
    }

    // переопределение метода вычисления длины для замкнутой ломаной
    @Override
    public double getLength() {
        double length = super.getLength();
        // Добавляем расстояние между последней и первой точкой
        length += getPoints()[getPoints().length - 1].distanceTo(getPoints()[0]);
        return length;
    }
}