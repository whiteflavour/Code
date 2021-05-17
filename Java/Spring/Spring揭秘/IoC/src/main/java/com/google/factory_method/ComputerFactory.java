package com.google.factory_method;

public class ComputerFactory {
    private ComputerFactory() {
    }

    public static Laptop getLaptop() {
        return new Laptop();
    }

    public static Desktop getDesktop() {
        return new Desktop();
    }
}
