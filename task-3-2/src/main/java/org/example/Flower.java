package org.example;

public abstract class Flower {
    protected String name;
    protected double price;
    protected int freshness;

    public Flower(String name, double price, int freshness) {
        this.name = name;
        this.price = price;
        if (freshness < 0 || freshness > 10) {
            throw new IllegalArgumentException("Свежесть должна быть от 0 до 10 дней.");
        }
        this.freshness = freshness;
    }

    public double getPrice() {
        return price;
    }

    public int getFreshness() {
        return freshness;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%s (цена: %.2f, свежесть: %d дней)", name, price, freshness);
    }
}