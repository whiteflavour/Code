package com.google.junit;

public class Demo {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        System.out.println(sum(2, 3));
        System.out.println(subtract(9, 5));
    }

    public static int sum(int numberA, int numberB) {
        return numberA + numberB;
    }

    public static int subtract(int numberA, int numberB) {
        return numberA - numberB;
    }
}
