package ru.elizarov.geometry;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public final class Point3D extends Point {
    private final int z;

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    @Override
    public String getTextRepresentation() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    @Override
    public String getDescription() {
        return "Точка в координате {" + getX() + ";" + getY() + ";" + z + "}";
    }

    public int getZ() {
        return z;
    }

    @Override
    public double distanceTo(Point other) {
        if (other == null) {
            throw new IllegalArgumentException("Другая точка не может быть null.");
        }
        if (other instanceof Point3D) {
            Point3D other3D = (Point3D) other;
            int dx = this.getX() - other3D.getX();
            int dy = this.getY() - other3D.getY();
            int dz = this.getZ() - other3D.getZ();
            return Math.sqrt(dx * dx + dy * dy + dz * dz);
        } else {
            return super.distanceTo(other);
        }
    }


}