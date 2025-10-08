package org.example;

public class ChassisStep implements ILineStep {
    @Override
    public IProductPart buildProductPart() {
        System.out.println("Создание шасси...");
        return new ChassisPart("Алюминиевое шасси");
    }
}