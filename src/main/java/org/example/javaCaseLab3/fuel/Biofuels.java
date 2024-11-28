package org.example.javaCaseLab3.fuel;

public class Biofuels implements Fuel{

    private String type;

    public Biofuels() {
        this.type = "Биотопливо";
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
