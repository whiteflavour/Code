package com.google.factory_method;

public class Alien {
    // private Laptop laptop = ComputerFactory.getLaptop();
    private Desktop desktop = ComputerFactory.getDesktop();

    public void code() {
       // System.out.println("Coding " + laptop.showMethod());
         System.out.println("Coding " + desktop.showMethod());
    }
}
