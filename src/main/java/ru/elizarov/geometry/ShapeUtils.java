package ru.elizarov.geometry;

public class ShapeUtils {
    public static double calculateTotalArea(Shape... shapes) {
        double totalArea = 0;
        //для каждой фигуры вызываем calculateArea() и все складвыем
        for (Shape shape : shapes) {
            totalArea += shape.calculateArea();
        }
        return totalArea;
    }
}