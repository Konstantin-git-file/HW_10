package ru.elizarov.geometry;

import java.util.ArrayList;
import java.util.List;

public class PolylineMerger {
    public static Polyline mergePolylines(List<? extends HasPolyline> objects) {
        List<Point> mergedPoints = new ArrayList<>();

        for (HasPolyline obj : objects) {
            Polyline polyline = obj.getPolyline();
            for (Point point : polyline.getPoints()) {
                mergedPoints.add(point);
            }
        }

        return new Polyline(mergedPoints.toArray(new Point[0]));
    }
}
