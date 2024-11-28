package org.example.javaCaseLab2;

import java.util.ArrayList;
import java.util.List;

public class VectorFactory {
    public static Vector<Double> generateRandomVector(int dimension) {
        List<Double> coordinates = new ArrayList<>();
        for (int i = 0; i < dimension; i++) {
            coordinates.add(Math.random() * 10);
        }
        return new Vector<>(coordinates);
    }

    public static List<Vector<Double>> generateRandomVectors(int count, int dimension) {
        List<Vector<Double>> vectors = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            vectors.add(generateRandomVector(dimension));
        }
        return vectors;
    }
}
