package org.example.javaCaseLab1;

import java.util.Arrays;
import java.util.Collections;

public class ArrayOperations {

    public void startAllOperations(int[] intArray) {
        System.out.println("Максимальное значение: " + findMaxValue(intArray));
        System.out.println("Минимальное значение: " + findMinValue(intArray));
        System.out.println("Среднее значение: " + calculateAvg(intArray));
        System.out.println("Массив в порядке возрастания: " + Arrays.toString(sortArrayIncreasing(intArray)));
        System.out.println("Массив в порядке убывания: " + Arrays.toString(sortArrayDecreasing(intArray)));
    }

    public void startAllOperations(float[] floatArray) {
        System.out.println("Максимальное значение: " + findMaxValue(floatArray));
        System.out.println("Минимальное значение: " + findMinValue(floatArray));
        System.out.println("Среднее значение: " + calculateAvg(floatArray));
        System.out.println("Массив в порядке возрастания: " + Arrays.toString(sortArrayIncreasing(floatArray)));
        System.out.println("Массив в порядке убывания: " + Arrays.toString(sortArrayDecreasing(floatArray)));
    }

    public int findMaxValue(int[] intArray) {
        int startMaxValue = intArray[0];
        for (int value : intArray) {
            if (value > startMaxValue) {
                startMaxValue = value;
            }
        }
        return startMaxValue;
    }

    public float findMaxValue(float[] floatArray) {
        float startMaxValue = floatArray[0];
        for (float value : floatArray) {
            if (value > startMaxValue) {
                startMaxValue = value;
            }
        }
        return startMaxValue;
    }

    public int findMinValue(int[] intArray) {
        int startMinValue = intArray[0];
        for (int value : intArray) {
            if (value < startMinValue) {
                startMinValue = value;
            }
        }
        return startMinValue;
    }

    public float findMinValue(float[] floatArray) {
        float startMinValue = floatArray[0];
        for (float value : floatArray) {
            if (value < startMinValue) {
                startMinValue = value;
            }
        }
        return startMinValue;
    }

    public int calculateAvg(int[] intArray) {
        int sum = 0;
        for (int value : intArray) {
            sum += value;
        }
        return sum / intArray.length;
    }

    public float calculateAvg(float[] floatArray) {
        int sum = 0;
        for (float value : floatArray) {
            sum += value;
        }
        return (float) sum / floatArray.length;
    }

    public int[] sortArrayIncreasing(int[] intArray) {
        Arrays.sort(intArray);
        return intArray;
    }

    public float[] sortArrayIncreasing(float[] floatArray) {
        Arrays.sort(floatArray);
        return floatArray;
    }

    public int[] sortArrayDecreasing(int[] intArray) {
        Integer[] integerArray = Arrays.stream(intArray).boxed().toArray(Integer[]::new);
        Arrays.sort(integerArray, Collections.reverseOrder());
        return Arrays.stream(integerArray).mapToInt(Integer::intValue).toArray();
    }

    public float[] sortArrayDecreasing(float[] floatArray) {
        Float[] floatObjectArray = new Float[floatArray.length];

        for (int i = 0; i < floatArray.length; i++) {
            floatObjectArray[i] = floatArray[i];
        }

        Arrays.sort(floatObjectArray, Collections.reverseOrder());
        float[] sortedArray = new float[floatObjectArray.length];

        for (int i = 0; i < floatObjectArray.length; i++) {
            sortedArray[i] = floatObjectArray[i];
        }
        return sortedArray;
    }
}

