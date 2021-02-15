package com.google.collecions_test.set_map_test;

import org.junit.Test;

import java.util.*;

public class MapTest {
    /**
     * HashMap test.
     *
     * @date 2021-1-17
     * @author Liao
     */
    @Test
    public void hashMapTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Tom");
        hashMap.put(2, "Jerry");
        hashMap.put(3, "Foo");
        hashMap.put(4, "Fuck");
        hashMap.put(5, "Jack");

        Iterator<Integer> iter = hashMap.keySet().iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

//        System.out.println(hashMap.merge(1, "FFF", (k, v) -> v.toUpperCase()));

//        System.out.println(hashMap.computeIfPresent(1, (k, v) -> v.toUpperCase()));
        System.out.println(hashMap);
    }

    /**
     * HashMap EntrySet test.
     *
     * @date 2021-1-18
     * @author Liao
     */
    @Test
    public void entrySetTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Tom");
        hashMap.put(2, "Jerry");
        hashMap.put(3, "Foo");
        hashMap.put(4, "Fuck");
        hashMap.put(5, "Jack");

        Set<Map.Entry<Integer, String>> set = hashMap.entrySet();
        Iterator<Map.Entry<Integer, String>> iter = set.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

    /**
     * HashMap reinsert a same key test.
     *
     * @date 2021-1-17
     * @author Liao
     */
    @Test
    public void sameKeyReinsertionTest() {
        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "Tom");
        hashMap.put(2, "Jerry");
        hashMap.put(6, "Jerry");
        hashMap.put(3, "Foo");
        hashMap.put(4, "Fuck");
        hashMap.put(5, "Jack");

        // 不要这样使用，有危险，建议使用 replace() 方法，不要瞎搞。
        hashMap.put(1, "JJJ");
        System.out.println(hashMap);
        System.out.println(hashMap.get(0));
    }

    /**
     * LinkedHashMap test.
     *
     * @date 2021-1-18
     * @author Liao
     */
    @Test
    public void linkedHashMapTest() {
        LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put(1, "Tom");
        linkedHashMap.put(2, "Jerry");
        linkedHashMap.put(6, "Jerry");
        linkedHashMap.put(3, "Foo");
        linkedHashMap.put(4, "Fuck");
        linkedHashMap.put(5, "Jack");



        System.out.println(linkedHashMap);
    }
}
