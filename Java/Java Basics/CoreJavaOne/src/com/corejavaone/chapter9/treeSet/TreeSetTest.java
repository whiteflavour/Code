package com.corejavaone.chapter9.treeSet;

import java.util.*;

/**
 * 程序清单 9-3 P367
 * This program sorts a set of item by comparing their description.
 * @version 1.12 2015-06-21
 * @author Cay Horstmann
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println("parts = " + parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println("sortByDescription = " + sortByDescription);
    }
}
