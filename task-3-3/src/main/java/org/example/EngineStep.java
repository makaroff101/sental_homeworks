package org.example;

public class EngineStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Создание двигателя...");
        return new EnginePart("Турбированный двигатель V6");
    }
}