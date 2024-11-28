package org.example.javaCaseLab2;

import java.util.List;

public class Vector<T extends Number> {

    private final List<T> coordinates;

    public Vector(List<T> coordinates) {
        this.coordinates = coordinates;
    }

    public List<T> getCoordinates() {
        return coordinates;
    }

    @Override
    public String toString() {
        return coordinates.toString();
    }
}