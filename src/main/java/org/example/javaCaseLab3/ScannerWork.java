package org.example.javaCaseLab3;

import org.example.javaCaseLab3.engine.BioFuelEngine;
import org.example.javaCaseLab3.engine.DieselEngine;
import org.example.javaCaseLab3.engine.PetrolEngine;
import org.example.javaCaseLab3.fuel.Biofuels;
import org.example.javaCaseLab3.fuel.Diesel;
import org.example.javaCaseLab3.fuel.Petrol;
import org.example.javaCaseLab3.transport.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ScannerWork {
    private Scanner scanner = new Scanner(System.in);
    private Transport transport = null;
    int choice;

    public void start() {
        try {
            getInput();
            correctTransport();
            printInfo();
        } catch (Exception e) {
            System.out.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private void getInput() {
        while (true) {
            System.out.println("1 - машина, 2 - грузовик, 3 - самолет, 4 - корабль");
            System.out.print("Выберите число: ");
            try {
                choice = scanner.nextInt();
                if (choice >= 1 && choice <= 4) {
                    break;
                } else {
                    System.out.println("Ошибка: Число должно быть от 1 до 4.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: Некорректный ввод. Введите целое число.");
                scanner.next(); // Очистка некорректного ввода
            }
        }
    }

    private void correctTransport() {
        switch (choice) {
            case 1: transport = new Car(Color.PINK, new PetrolEngine(), new Petrol()); break;
            case 2: transport = new Truck(Color.RED, new DieselEngine(), new Diesel()); break;
            case 3: transport = new Plane(Color.WHITE, new BioFuelEngine(), new Biofuels()); break;
            case 4: transport = new Ship(Color.BROWN, new BioFuelEngine(), new Biofuels()); break;
            default: throw new IllegalStateException("Некорректное состояние выбора транспорта.");
        }
    }

    private void printInfo() {
        if (transport == null) {
            System.out.println("Ошибка: Транспорт не создан.");
            return;
        }

        try {
            System.out.println("Тип транспорта: " + transport.getType());
            System.out.println("Цвет транспорта: " + transport.getColor());
            System.out.println("Тип двигателя: " + transport.getEngine());
            System.out.println("Тип топлива: " + transport.getFuel());
        } catch (NullPointerException e) {
            System.out.println("Ошибка: Некорректные данные транспорта.");
        }
    }
}

