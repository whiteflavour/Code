package com.corejavaone.demo;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class StrDemo {
    public static void main(String[] args) {
        List<Integer> i = new LinkedList<>();
        i.add(1);
        i.add(2);
        i.add(3);
        System.out.println("Before removed: ");
        i.forEach((v) -> System.out.println("v = " + v));
        ListIterator iter = i.listIterator();
        iter.next();
        iter.next();
        iter.remove();
        System.out.println("After removed: ");
        i.forEach((v) -> System.out.println("v = " + v));
    }
}