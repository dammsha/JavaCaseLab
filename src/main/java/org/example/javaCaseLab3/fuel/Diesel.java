package org.example.javaCaseLab3.fuel;

public class Diesel implements Fuel{

    private String type;

    public Diesel() {
        this.type = "Дизальное";
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
