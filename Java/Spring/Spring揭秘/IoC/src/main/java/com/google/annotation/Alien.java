package com.google.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Alien {
    @Autowired
    private Laptop laptop;
    private Desktop desktop;

    public Alien() {
    }

    public Alien(Laptop laptop, Desktop desktop) {
        this.laptop = laptop;
        this.desktop = desktop;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public Desktop getDesktop() {
        return desktop;
    }

    public void setDesktop(Desktop desktop) {
        this.desktop = desktop;
    }
}
