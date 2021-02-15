package com.google.collecions_test.set_map_test;

import org.junit.Test;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetTest {
    @Test
    public void hashSetTest() {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("Tom");
        hashSet.add("Jerry");
        hashSet.add("Foo");
        hashSet.add("Fuck");
        hashSet.add("Jack");

        System.out.println(hashSet);
        hashSet.clear();
        System.out.println(hashSet);
    }

    /**
     * LinkedHashSetTest————forEach();
     * @author Liao
     * @date 2021-1-5
     */
    @Test
    public void linkedHashSetForEachTest() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Tom");
        linkedHashSet.add("Jerry");
        linkedHashSet.add("Foo");
        linkedHashSet.add("Fuck");
        linkedHashSet.add("Jack");

        linkedHashSet.forEach(e -> System.out.print(e.toUpperCase() + " "));
    }

    /**
     * LinkedHashSetTest————stream();
     * @author Liao
     * @date 2021-1-5
     */
    @Test
    public void linkedHashSetStreamTest() {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("Tom");
        linkedHashSet.add("Jerry");
        linkedHashSet.add("Foo");
        linkedHashSet.add("Fuck");
        linkedHashSet.add("Jack");

        long count = linkedHashSet.stream().filter(s -> s.equals("Fuck")).count();
        System.out.println(count);
    }
}
