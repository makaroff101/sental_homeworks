package org.example;

public class Tulip extends Flower {
    private String variety;

    public Tulip(String variety, double price, int freshness) {
        super("Тюльпан", price, freshness);
        this.variety = variety;
    }

    public String getVariety() {
        return variety;
    }

    @Override
    public String toString() {
        return String.format("%s %s", variety, super.toString());
    }
}