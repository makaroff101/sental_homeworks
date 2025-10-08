package org.example;

public class Rose extends Flower {
    private String color;

    public Rose(String color, double price, int freshness) {
        super("Роза", price, freshness);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return String.format("%s %s", color, super.toString());
    }
}