package ru.elizarov.geometry;

public class SizedPoint extends Point {
    private final Point point;
    private final int size;

    public SizedPoint(Point point, int size) {
        super(point.getX(), point.getY());
        this.point = point;
        this.size = size;
    }

    @Override
    public String getDescription() {
        return point.getDescription() + ", размер: " + size;
    }
}