package org.example.javaCaseLab2;

import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public class Vector {

    private ArrayList<Double> coordinates;

    public Vector(ArrayList<Double> coordinates){
        this.coordinates = coordinates;
    }

    public void start(Vector secondVector) {
        System.out.println("Длина вектора: " + calculateVectorLength());
        System.out.println("Скалярное произведение векторов " + this + " и " + secondVector + ": " + calculateScalarProduct(secondVector));
        System.out.println("Векторное произведение векторов " + this + " и " + secondVector + ": " + calculateVectorProduct(secondVector));
        System.out.println("Косинус угла между вектором " + this + " и " + secondVector + ": " + calculateCos(secondVector));
        System.out.println("Сумма векторов " + this + " и " + secondVector + ": " + sumVectors(secondVector));
        System.out.println("Разность векторов " + this + " и " + secondVector + ": " + substractVectors(secondVector));
    }

    private double calculateVectorLength() {
        return sqrt(pow(coordinates.get(0), 2) + pow(coordinates.get(1), 2) + pow(coordinates.get(2), 2));
    }

    private double calculateScalarProduct(Vector secondVector) {
        double scalarProduct = 0;
        for (int i = 0; i < 3; i++) {
            scalarProduct += (coordinates.get(i) * secondVector.coordinates.get(i));
        }
        return scalarProduct;
    }

    private Vector calculateVectorProduct(Vector secondVector) {
        return new Vector(new ArrayList<>(List.of(
                this.coordinates.get(1) * secondVector.coordinates.get(2) - this.coordinates.get(2) * secondVector.coordinates.get(1),
                this.coordinates.get(2) * secondVector.coordinates.get(0) - this.coordinates.get(0) * secondVector.coordinates.get(2),
                this.coordinates.get(0) * secondVector.coordinates.get(1) - this.coordinates.get(1) * secondVector.coordinates.get(0)
        )));
    }

    private double calculateCos(Vector secondVector) {
        return calculateScalarProduct(secondVector) / calculateVectorLength() * secondVector.calculateVectorLength();
    }

    private Vector sumVectors(Vector secondVector) {
        return new Vector(new ArrayList<>(List.of(
                this.coordinates.get(0) + secondVector.coordinates.get(0),
                this.coordinates.get(1) + secondVector.coordinates.get(1),
                this.coordinates.get(2) + secondVector.coordinates.get(2)
        )));
    }

    private Vector substractVectors(Vector secondVector) {
        return new Vector(new ArrayList<>(List.of(
                this.coordinates.get(0) - secondVector.coordinates.get(0),
                this.coordinates.get(1) - secondVector.coordinates.get(1),
                this.coordinates.get(2) - secondVector.coordinates.get(2)
        )));
    }

    @Override
    public String toString() {
        return "{"+ coordinates.get(0) + "," + coordinates.get(1) + "," + coordinates.get(2) + "}";
    }

    protected static Vector[] generateVectors(int n) {
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++){
            vectors[i] = new Vector(new ArrayList<>(List.of(Math.random() * 10, Math.random() * 10, Math.random() * 10)));
            System.out.println("Вектор №" + (i + 1) + " в сгенерированном массиве " + vectors[i]);
        }
        return vectors;
    }
}