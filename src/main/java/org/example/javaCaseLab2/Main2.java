package org.example.javaCaseLab2;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        Vector<Double> vector1 = new Vector<>(List.of(3.0, 4.0, 0.0));
        Vector<Double> vector2 = new Vector<>(List.of(1.0, 1.0, 1.0));

        VectorOperations operations = new VectorOperations(vector1);
        operations.performOperations(vector2);

        List<Vector<Double>> randomVectors = VectorFactory.generateRandomVectors(5, 3);
        System.out.println("Сгенерированные векторы:");
        for (Vector<Double> vector : randomVectors) {
            System.out.println(vector);
        }
    }
}
