package ru.elizarov.geometry;

public class ColoredPoint extends Point {
    private final Point point;
    private final String color;

    public ColoredPoint(Point point, String color) {
        super(point.getX(), point.getY());
        this.point = point;
        this.color = color;
    }

    @Override
    public String getDescription() {
        return point.getDescription() + ", цвет: " + color;
    }
}