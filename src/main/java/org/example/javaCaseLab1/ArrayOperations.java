package org.example.javaCaseLab1;

import java.util.Arrays;
import java.util.Collections;


public class ArrayOperations<T extends Number> implements ArrayInterface<T> {

    @Override
    public T findMaxValue(T[] array) {
        return Arrays.stream(array).max((a, b) -> Double.compare(a.doubleValue(), b.doubleValue())).orElseThrow();
    }

    @Override
    public T findMinValue(T[] array) {
        return Arrays.stream(array).min((a, b) -> Double.compare(a.doubleValue(), b.doubleValue())).orElseThrow();
    }

    @Override
    public double calculateAvg(T[] array) {
        return Arrays.stream(array).mapToDouble(Number::doubleValue).average().orElse(0.0);
    }

    @Override
    public T[] sortArrayIncreasing(T[] array) {
        Arrays.sort(array, (a, b) -> Double.compare(a.doubleValue(), b.doubleValue()));
        return array;
    }

    @Override
    public T[] sortArrayDecreasing(T[] array) {
        Arrays.sort(array, Collections.reverseOrder((a, b) -> Double.compare(a.doubleValue(), b.doubleValue())));
        return array;
    }
}

