package org.example.javaCaseLab3;

import org.example.javaCaseLab3.engine.BioFuelEngine;
import org.example.javaCaseLab3.engine.DieselEngine;
import org.example.javaCaseLab3.engine.PetrolEngine;
import org.example.javaCaseLab3.fuel.Biofuels;
import org.example.javaCaseLab3.fuel.Diesel;
import org.example.javaCaseLab3.fuel.Petrol;
import org.example.javaCaseLab3.transport.*;

import java.util.Scanner;

public class ScannerWork {
    private Scanner scanner = new Scanner(System.in);
    Transport transport = null;
    int choice;

    public void start() {
        System.out.println("1 - машина, 2 - грузовик, 3 - самолет, 4 - корабль");
        System.out.println("Выберите число: ");
        choice = scanner.nextInt();
        validInput();
        correctTransport();
        printInfo();
        scanner.close();
    }

    private void validInput() {
        while (choice < 1 || choice > 4) {
            System.out.println("Введено некорректное число. Число должно быть от 1 до 4");
            System.out.println("Выберите число: ");
            choice = scanner.nextInt();
        }
    }

    private Transport correctTransport() {
        switch (choice) {
            case 1: {return transport = new Car(Color.PINK, new PetrolEngine(), new Petrol());}
            case 2: {return transport = new Truck(Color.RED, new DieselEngine(), new Diesel());}
            case 3: {return transport = new Plane(Color.WHITE, new BioFuelEngine(), new Biofuels());}
            case 4: {return transport = new Ship(Color.BROWN, new BioFuelEngine(), new Biofuels());}
        }
        return transport;
    }

    private void printInfo() {
        System.out.println("Тип транспорта: " + transport.getType());
        System.out.println("Цвет транспорта: " + transport.getColor());
        System.out.println("Тип двигателя: " + transport.getEngine());
        System.out.println("Тип топлива: " + transport.getFuel());
    }
}

