package org.example;

public class Chrysanthemum extends Flower {
    private boolean isSpherical;

    public Chrysanthemum(boolean isSpherical, double price, int freshness) {
        super("Хризантема", price, freshness);
        this.isSpherical = isSpherical;
    }

    public boolean isSpherical() {
        return isSpherical;
    }

    @Override
    public String toString() {
        String shape = isSpherical ? "шаровидная" : "обычная";
        return String.format("%s %s", shape, super.toString());
    }
}