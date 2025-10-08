package org.example;

public class BodyStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Создание кузова...");
        return new BodyPart("Стальной кузов");
    }
}