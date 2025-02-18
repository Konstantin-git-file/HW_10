package ru.elizarov.geometry;

import lombok.Data;

@Data
public class Line<T extends Point3D> implements Measurable, Cloneable {
    private T start;
    private T end;

    public Line(T start, T end) {
        this.start = start;
        this.end = end;
    }

//    public Line(Point start, Point end) {
//        this.start = new Point(start.getX(), start.getY());
//        this.end = new Point(end.getX(), end.getY());
//    }
//
//    public Line(int startX, int startY, int endX, int endY) {
//        this.start = new Point(startX, startY);
//        this.end = new Point(endX, endY);
//    }

    public double getLength() {
        return Math.sqrt(Math.pow(end.getX() - start.getX(), 2) + Math.pow(end.getY() - start.getY(), 2));
    }

//    public void setStart(int x, int y) {
//        this.start.setX(x);
//        this.start.setY(y);
//    }
//
//    public void setEnd(int x, int y) {
//        this.end.setX(x);
//        this.end.setY(y);
//    }

    @Override
    public String toString() {
        return "Линия от " + start.getTextRepresentation() + " до " + end.getTextRepresentation();
    }

    // условие по 5.1.3.
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Line line = (Line) obj;
        return (start.equals(line.start) && end.equals(line.end)) ||
                (start.equals(line.end) && end.equals(line.start));
    }

    @Override
    public int hashCode() {
        return start.hashCode() + end.hashCode();
    }

    // условие по 5.2.2.
    @Override
    public Line<T> clone() {
        try {
            return (Line<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("не поддерживается клонитрование ", e);
        }
    }
}