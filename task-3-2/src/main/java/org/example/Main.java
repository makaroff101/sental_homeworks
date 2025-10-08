package org.example;

public class Main {
    public static void main(String[] args) {
        Rose redRose = new Rose("Красная", 150.0, 2);
        Rose whiteRose = new Rose("Белая", 140.0, 3);
        Tulip fringedTulip = new Tulip("Махровый", 80.0, 1);
        Chrysanthemum sphericalChrys = new Chrysanthemum(true, 100.0, 4);
        Chrysanthemum regularChrys = new Chrysanthemum(false, 90.0, 5);

        Bouquet myBouquet = new Bouquet();

        myBouquet.addFlower(redRose);
        myBouquet.addFlower(whiteRose);
        myBouquet.addFlower(fringedTulip);
        myBouquet.addFlower(sphericalChrys);
        myBouquet.addFlower(regularChrys);

        myBouquet.printBouquet();
    }
}