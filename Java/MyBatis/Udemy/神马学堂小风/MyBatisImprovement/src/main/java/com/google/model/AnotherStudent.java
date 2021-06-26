package com.google.model;

public class AnotherStudent {
    private int aId;
    private String aName;
    private int aAge;

    public AnotherStudent() {
    }

    public AnotherStudent(String aName, int aAge) {
        this.aName = aName;
        this.aAge = aAge;
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

    public void setaName(String aName) {
        this.aName = aName;
    }

    public int getaAge() {
        return aAge;
    }

    public void setaAge(int aAge) {
        this.aAge = aAge;
    }

    @Override
    public String toString() {
        return "AnotherStudent{" +
                "aId=" + aId +
                ", aName='" + aName + '\'' +
                ", aAge=" + aAge +
                '}';
    }
}
