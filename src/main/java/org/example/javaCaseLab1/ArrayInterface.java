package org.example.javaCaseLab1;

public interface ArrayInterface<T extends Number> {
    T findMaxValue(T[] array);
    T findMinValue(T[] array);
    double calculateAvg(T[] array);
    T[] sortArrayIncreasing(T[] array);
    T[] sortArrayDecreasing(T[] array);
}
