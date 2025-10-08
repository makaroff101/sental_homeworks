package org.example;

public class BodyPart implements IProductPart {
    private String name;

    public BodyPart(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}