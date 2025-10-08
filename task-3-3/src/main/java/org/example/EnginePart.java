package org.example;

public class EnginePart implements IProductPart {
    private String name;

    public EnginePart(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}