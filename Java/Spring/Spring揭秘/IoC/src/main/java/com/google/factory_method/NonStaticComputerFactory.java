package com.google.factory_method;

public class NonStaticComputerFactory {
    public Desktop getDesktop() {
        return new Desktop();
    }
}
