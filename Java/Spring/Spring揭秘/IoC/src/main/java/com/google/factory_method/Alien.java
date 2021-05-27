package com.google.factory_method;

public class Alien {
    private Laptop laptop;

    public Alien() {
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}
