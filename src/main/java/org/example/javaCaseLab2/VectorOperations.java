package org.example.javaCaseLab2;

import java.util.ArrayList;
import java.util.List;

public class VectorOperations implements VectorOperationsInterface {
    private final Vector<Double> vector;

    public VectorOperations(Vector<Double> vector) {
        this.vector = vector;
    }

    private void validateDimension(Vector<Double> other) {
        if (vector.getCoordinates().size() != other.getCoordinates().size()) {
            throw new IllegalArgumentException("Размерности векторов не совпадают.");
        }
    }

    @Override
    public double calculateLength() {
        return Math.sqrt(vector.getCoordinates().stream()
                .mapToDouble(coord -> coord * coord)
                .sum());
    }

    @Override
    public double calculateDotProduct(Vector<Double> other) {
        validateDimension(other);
        List<Double> otherCoords = other.getCoordinates();
        double result = 0;
        for (int i = 0; i < vector.getCoordinates().size(); i++) {
            result += vector.getCoordinates().get(i) * otherCoords.get(i);
        }
        return result;
    }

    @Override
    public Vector<Double> calculateCrossProduct(Vector<Double> other) {
        if (vector.getCoordinates().size() != 3 || other.getCoordinates().size() != 3) {
            throw new UnsupportedOperationException("Векторное произведение определено только для трёхмерных векторов.");
        }

        List<Double> coords = new ArrayList<>();
        coords.add(vector.getCoordinates().get(1) * other.getCoordinates().get(2) -
                vector.getCoordinates().get(2) * other.getCoordinates().get(1));
        coords.add(vector.getCoordinates().get(2) * other.getCoordinates().get(0) -
                vector.getCoordinates().get(0) * other.getCoordinates().get(2));
        coords.add(vector.getCoordinates().get(0) * other.getCoordinates().get(1) -
                vector.getCoordinates().get(1) * other.getCoordinates().get(0));
        return new Vector<>(coords);
    }

    @Override
    public double calculateCos(Vector<Double> other) {
        validateDimension(other);
        double dotProduct = calculateDotProduct(other);
        double lengthProduct = calculateLength() * new VectorOperations(other).calculateLength();
        return dotProduct / lengthProduct;
    }

    @Override
    public Vector<Double> add(Vector<Double> other) {
        validateDimension(other);
        List<Double> coords = new ArrayList<>();
        for (int i = 0; i < vector.getCoordinates().size(); i++) {
            coords.add(vector.getCoordinates().get(i) + other.getCoordinates().get(i));
        }
        return new Vector<>(coords);
    }

    @Override
    public Vector<Double> subtract(Vector<Double> other) {
        validateDimension(other);
        List<Double> coords = new ArrayList<>();
        for (int i = 0; i < vector.getCoordinates().size(); i++) {
            coords.add(vector.getCoordinates().get(i) - other.getCoordinates().get(i));
        }
        return new Vector<>(coords);
    }

    public void performOperations(Vector<Double> other) {
        System.out.println("Длина вектора: " + calculateLength());
        System.out.println("Скалярное произведение с " + other + ": " + calculateDotProduct(other));
        System.out.println("Косинус угла с " + other + ": " + calculateCos(other));
        System.out.println("Сумма с " + other + ": " + add(other));
        System.out.println("Разность с " + other + ": " + subtract(other));

        try {
            System.out.println("Векторное произведение с " + other + ": " + calculateCrossProduct(other));
        } catch (UnsupportedOperationException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}
