package org.example.javaCaseLab1;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWork {

    private Scanner scanner = new Scanner(System.in);

    public void start() {
        try {
            int size = getIntInput("Введите размер массива: ", "Размер должен быть положительным целым числом.");
            int type = getIntInput("Введите тип массива (1 - целые числа, 2 - дробные числа): ", "Введите 1 или 2.");
            double min = getDoubleInput("Введите минимальное значение: ", "Некорректное значение.");
            double max = getDoubleInput("Введите максимальное значение: ", "Некорректное значение.");

            while (max < min) {
                System.out.println("Максимальное значение должно быть больше минимального.");
                max = getDoubleInput("Введите максимальное значение: ", "Некорректное значение.");
            }

            if (type == 1) {
                Integer[] array = generateArray(size, (int) min, (int) max);
                ArrayOperations<Integer> operations = new ArrayOperations<>();
                processArray(array, operations);
            } else {
                Double[] array = generateArray(size, min, max);
                ArrayOperations<Double> operations = new ArrayOperations<>();
                processArray(array, operations);
            }
        } finally {
            scanner.close();
        }
    }

    private <T extends Number> void processArray(T[] array, ArrayOperations<T> operations) {
        System.out.println("Максимальное значение: " + operations.findMaxValue(array));
        System.out.println("Минимальное значение: " + operations.findMinValue(array));
        System.out.println("Среднее значение: " + operations.calculateAvg(array));
        System.out.println("Сортировка по возрастанию: " + Arrays.toString(operations.sortArrayIncreasing(array)));
        System.out.println("Сортировка по убыванию: " + Arrays.toString(operations.sortArrayDecreasing(array)));
    }

    private Integer[] generateArray(int size, int min, int max) {
        Integer[] array = new Integer[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + (int) (Math.random() * (max - min + 1));
        }
        return array;
    }

    private Double[] generateArray(int size, double min, double max) {
        Double[] array = new Double[size];
        for (int i = 0; i < size; i++) {
            array[i] = min + Math.random() * (max - min);
        }
        return array;
    }

    private int getIntInput(String prompt, String errorMessage) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next();
            }
        }
    }

    private double getDoubleInput(String prompt, String errorMessage) {
        while (true) {
            try {
                System.out.print(prompt);
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(errorMessage);
                scanner.next();
            }
        }
    }
}