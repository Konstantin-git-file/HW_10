package ru.elizarov.geometry;

class Square extends Shape implements HasPolyline {
    private double side;

    public Square(double side) {
        if (side <= 0) {
            throw new IllegalArgumentException("Сторона должна быть положительной.");
        }
        this.side = side;
    }

    @Override
    public double calculateArea() {
        return side * side;
    }

    /*
           2.3.6 Замкнутый квадрат. Измените сущность Квадрат из задачи
           1.6.3 таким образом что бы она возвращала не обычную ломаную линию,
           а замкнутую ломаную линию из задачи 2.1.2. При этом сигнатура метода,
           возвращающую Ломаную, должна остаться без изменений.
             */
    public Polyline toPolyline() {
        // вершины квадрата
        Point[] points = new Point[]{
                new Point(0, 0),
                new Point((int) side, 0),
                new Point((int) side, (int) side),
                new Point(0, (int) side),
                new Point(0, 0) // замыкаем
        };
        return new ClosedPolyline(points);
    }

    @Override
    public Polyline getPolyline() {
        // Создаем вершины квадрата
        Point[] points = new Point[]{
                new Point(0, 0),
                new Point((int) side, 0),
                new Point((int) side, (int) side),
                new Point(0, (int) side),
                new Point(0, 0) // Замыкаем ломаную
        };
        return new Polyline(points);
    }
}
