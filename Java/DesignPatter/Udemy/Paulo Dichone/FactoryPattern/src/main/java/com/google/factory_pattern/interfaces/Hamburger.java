package com.google.factory_pattern.interfaces;

public abstract class Hamburger {
    private String name;
    private String sauce;
    private String buns;

    protected void prepare() {
        System.out.println("Preparing " + name + "...");
        System.out.println("Adding " + sauce + "...");
        System.out.println("Adding " + buns + "...");
    }

    protected void cook() {
        System.out.println("Cooking...");
    }

    protected void box() {
        System.out.println("Boxing...");
    }

    public String getName() {
        return name;
    }

    protected void setName(String name) {
        this.name = name;
    }

    public String getSauce() {
        return sauce;
    }

    protected void setSauce(String sauce) {
        this.sauce = sauce;
    }

    public String getBuns() {
        return buns;
    }

    protected void setBuns(String buns) {
        this.buns = buns;
    }
}
