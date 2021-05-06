package com.google.model;

public class Alien {
    private int aId;

    @Override
    public String toString() {
        return "Alien{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                '}';
    }

    public int getaId() {
        return aId;
    }

    public void setaId(int aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public Alien() {
    }

    public Alien(int aId, String aName) {
        this.aId = aId;
        this.aName = aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    private String aName;
}
