package org.example;

public class Car implements IProduct {
    private IProductPart body;
    private IProductPart chassis;
    private IProductPart engine;

    @Override
    public void installFirstPart(IProductPart part) {
        this.body = part;
        System.out.println("Установлен кузов: " + part.getName());
    }

    @Override
    public void installSecondPart(IProductPart part) {
        this.chassis = part;
        System.out.println("Установлено шасси: " + part.getName());
    }

    @Override
    public void installThirdPart(IProductPart part) {
        this.engine = part;
        System.out.println("Установлен двигатель: " + part.getName());
    }

    @Override
    public String toString() {
        return "Автомобиль [кузов=" + (body != null ? body.getName() : "не установлен") +
                ", шасси=" + (chassis != null ? chassis.getName() : "не установлено") +
                ", двигатель=" + (engine != null ? engine.getName() : "не установлен") + "]";
    }
}