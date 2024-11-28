package org.example.javaCaseLab2;

public interface VectorOperationsInterface {
    double calculateLength();
    double calculateDotProduct(Vector<Double> other);
    Vector<Double> calculateCrossProduct(Vector<Double> other);
    double calculateCos(Vector<Double> other);
    Vector<Double> add(Vector<Double> other);
    Vector<Double> subtract(Vector<Double> other);
}
