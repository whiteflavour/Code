package com.google.collecions_test.list_test.linkedlist_test;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListTest {
    @Test
    public void linkedListTest() {
        LinkedList<String> linkedList = new LinkedList<>();
//        linkedList.add(null);
        linkedList.add("Tom");
        linkedList.add("Jerry");
        linkedList.add("Foo");
        linkedList.add("Fuck");
        linkedList.add("Jack");

        linkedList.replaceAll(String::toUpperCase);
//        System.out.println(linkedList.removeFirst());
//        System.out.println(linkedList.pollFirst());

        System.out.println(linkedList);

        // listIterator()
        /*Iterator<String> iter = linkedList.listIterator(1);
        System.out.println(iter.next());*/

        // descendingIterator()
        /*Iterator<String> deIter = linkedList.descendingIterator();
        System.out.println(deIter.next());*/
    }
}
