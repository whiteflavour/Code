package com.google.collecions_test;

import org.junit.Test;
import java.util.Stack;

// Stack, List, LinkedList, Iterator, fori foreach Iterator, Set
public class OtherTest {
    // Stack
    @Test
    public void StackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        stack.push(7);
        System.out.println(stack.peek());

        
        /*Integer[] array = new Integer[6];
        stack.copyInto(array);

        for (Integer value :
                array) {
            System.out.println(value);
        }*/
    }

}
