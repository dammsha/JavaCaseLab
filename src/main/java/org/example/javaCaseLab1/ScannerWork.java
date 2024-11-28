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
        size = getIntInput("Введите размер массива: ", "Введено некорректное число, повторите ввод: ");
        type = getInputType("Введите тип списка. 1 - целое числа, 2 - дробные числа: ", "Введено некорректное число, повторите ввод: ");
        max = getFloatInput("Введите максимум: ", "Введено некорректное значение, повторите ввод: ");
        min = getFloatInput("Введите минимум: ", "Введено некорректное значение, повторите ввод: ");

        while (max < min) {
            System.out.println("Максимум должен быть больше минимума. Введите снова");
            max = getFloatInput("Введите максимум: ", "Введено некорректное значение, повторите ввод: ");
            min = getFloatInput("Введите минимум: ", "Введено некорректное значение, повторите ввод: ");
        }

        scanner.close();
        generateArray(type);
    }

    private int getIntInput(String startMsg, String errorMsg) {
        while (true) {
            System.out.print(startMsg);
            try {
                int input = scanner.nextInt();
                if (input > 0) {
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
        if (type == 1) {
            this.intArray = generateIntArray(size, max, min);
            arrayOperations.startAllOperations(intArray);
        } else {
            this.floatArray = generateFloatArray(size, max, min);
            arrayOperations.startAllOperations(floatArray);
        }
    }

    private int[] generateIntArray(int size, float max, float min) {
        intArray = new int[size];
        for (int i = 0; i < size; i++) {
            intArray[i] = (int) ((Math.random() * (max - min + 1)) + min);
        }
        return intArray;
    }

    private float[] generateFloatArray(int size, float max, float min) {
        floatArray = new float[size];
        for (int i = 0; i < size; i++) {
            floatArray[i] = (float) (Math.random() * (max - min) + min);
        }
        return floatArray;
    }
}

