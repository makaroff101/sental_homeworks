package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bouquet {
    private List<Flower> flowers;

    public Bouquet() {
        this.flowers = new ArrayList<>();
    }

    public void addFlower(Flower flower) {
        flowers.add(flower);
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (Flower flower : flowers) {
            total += flower.getPrice();
        }
        return total;
    }

    public List<Flower> getFlowers() {
        return new ArrayList<>(flowers);
    }

    public void printBouquet() {
        System.out.println("Содержимое букета:");
        for (int i = 0; i < flowers.size(); i++) {
            System.out.printf("%d. %s%n", i + 1, flowers.get(i));
        }
        System.out.printf("Общая стоимость букета: %.2f%n", getTotalPrice());
    }
}