package org.example.javaCaseLab1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWork {

    private Scanner scanner = new Scanner(System.in);
    private ArrayOperations arrayOperations = new ArrayOperations();
    private int[] intArray;
    private float[] floatArray;
    private int size;
    private int type;
    private float max;
    private float min;

    public void start() {
        try {
            size = getIntInput("Введите размер массива: ", "Размер должен быть положительным целым числом.");
            type = getInputType("Введите тип массива (1 - целые числа, 2 - дробные числа): ", "Введите 1 или 2.");
            max = getFloatInput("Введите максимальное значение: ", "Некорректное значение. Повторите ввод.");
            min = getFloatInput("Введите минимальное значение: ", "Некорректное значение. Повторите ввод.");

            while (max < min) {
                System.out.println("Ошибка: Максимальное значение не может быть меньше минимального.");
                max = getFloatInput("Введите максимальное значение: ", "Некорректное значение. Повторите ввод.");
                min = getFloatInput("Введите минимальное значение: ", "Некорректное значение. Повторите ввод.");
            }

            generateArray(type);
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private int getIntInput(String startMsg, String errorMsg) {
        while (true) {
            System.out.print(startMsg);
            try {
                int input = scanner.nextInt();
                if (input > 0) {
                    return input;
                } else {
                    System.out.println("Ошибка: значение должно быть больше 0.");
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMsg);
                scanner.next();
            }
        }
    }

    private int getInputType(String startMsg, String errorMsg) {
        while (true) {
            System.out.print(startMsg);
            try {
                int input = scanner.nextInt();
                if (input == 1 || input == 2) {
                    return input;
                } else {
                    System.out.println(errorMsg);
                }
            } catch (InputMismatchException e) {
                System.out.println(errorMsg);
                scanner.next();
            }
        }
    }

    private float getFloatInput(String startMsg, String errorMsg) {
        while (true) {
            System.out.print(startMsg);
            try {
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println(errorMsg);
                scanner.next();
            }
        }
    }

    private void generateArray(int type) {
        try {
            if (type == 1) {
                this.intArray = generateIntArray(size, max, min);
                arrayOperations.startAllOperations(intArray);
            } else if (type == 2) {
                this.floatArray = generateFloatArray(size, max, min);
                arrayOperations.startAllOperations(floatArray);
            } else {
                throw new IllegalArgumentException("Некорректный тип массива.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Неожиданная ошибка при генерации массива: " + e.getMessage());
        }
    }

    private int[] generateIntArray(int size, float max, float min) {
        if (max < min) {
            throw new IllegalArgumentException("Максимальное значение меньше минимального.");
        }
        int[] intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = (int) ((Math.random() * (max - min + 1)) + min);
        }
        return intArray;
    }

    private float[] generateFloatArray(int size, float max, float min) {
        if (max < min) {
            throw new IllegalArgumentException("Максимальное значение меньше минимального.");
        }
        float[] floatArray = new float[size];
        for (int i = 0; i < size; i++) {
            floatArray[i] = (float) (Math.random() * (max - min) + min);
        }
        return floatArray;
    }
}