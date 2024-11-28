package org.example.javaCaseLab3.transport;

import org.example.javaCaseLab3.Color;
import org.example.javaCaseLab3.engine.Engine;
import org.example.javaCaseLab3.fuel.Fuel;

public class Car extends Transport{

    public Car(Color color, Engine engine, Fuel fuel) {
        super(color, engine, fuel);
        this.type = "Машина";
    }
}