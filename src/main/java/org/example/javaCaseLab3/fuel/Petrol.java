package org.example.javaCaseLab3.fuel;

public class Petrol implements Fuel {

    private String type;

    public Petrol() {
        this.type = "Бензин";
    }

    @Override
    public void infoFuel() {
        System.out.println("Топливо: " + type);
    }

    @Override
    public String getType() {
        return type;
    }
}
