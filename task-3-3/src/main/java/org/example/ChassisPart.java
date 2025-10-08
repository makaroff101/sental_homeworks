package org.example;

public class ChassisPart implements IProductPart {
    private String name;

    public ChassisPart(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}