package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("ТЕСТИРОВАНИЕ СБОРОЧНОЙ ЛИНИИ\n");

        ILineStep bodyStep = new BodyStep();
        ILineStep chassisStep = new ChassisStep();
        ILineStep engineStep = new EngineStep();

        IAssemblyLine carAssemblyLine = new AssemblyLine(bodyStep, chassisStep, engineStep);

        IProduct carPrototype = new Car();

        IProduct assembledCar = carAssemblyLine.assembleProduct(carPrototype);

        System.out.println("\nГотовый продукт:");
        System.out.println(assembledCar);
    }
}