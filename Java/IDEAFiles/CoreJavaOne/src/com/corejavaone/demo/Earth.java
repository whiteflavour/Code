package com.corejavaone.demo;

/**
 * 单例设计模式
 */
public class Earth {
    private static Earth earth = new Earth();
    private Earth() {}
    public static Earth getEarthInstance() {
        return earth;
    }
    public void playing() {
        System.out.println("Hello");
    }
}
