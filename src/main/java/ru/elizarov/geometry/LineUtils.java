package ru.elizarov.geometry;

public class LineUtils {
    public static <T extends Point3D> void shiftLine(Line<T> line) {
        T start = line.getStart();
        line.setStart((T) new Point3D(start.getX() + 10, start.getY(), start.getZ()));
    }
}