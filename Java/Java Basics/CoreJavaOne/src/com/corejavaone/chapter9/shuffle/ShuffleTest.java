package com.corejavaone.chapter9.shuffle;

import java.util.*;

/**
 * 程序清单 9-7 P390
 * This program demonstrates the random shuffle and sort algorithms.
 * @version 1.11 2012-01-26
 * @author Cay Horstmann
 */
public class ShuffleTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 49; ++i) {
            numbers.add(i);
        }
//        numbers.forEach((v) -> System.out.println("v = " + v));
        Collections.shuffle(numbers);
        List<Integer> winningCombination = numbers.subList(0, 6);
//        winningCombination.forEach((v) -> System.out.print("v = " + v + ", "));
        Collections.sort(winningCombination);
        System.out.println("winningCombination = " + winningCombination);
    }
}
