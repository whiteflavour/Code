package com.google.proxy.proxy_design_pattern;

public class Alien {
    private Computer computer;

    public Alien(Computer computer) {
        this.computer = computer;
    }

    public Computer getComputer() {
        return computer;
    }

    public void setComputer(Computer computer) {
        this.computer = computer;
    }
}
