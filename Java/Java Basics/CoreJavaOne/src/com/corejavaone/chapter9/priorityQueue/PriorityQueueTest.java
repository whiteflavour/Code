package com.corejavaone.chapter9.priorityQueue;

import java.util.*;
import java.time.*;

/**
 * 程序清单 9-5 P371
 * This program demonstrates the use of a priority queue.
 * @version 1.01 2012-01-26
 * @author Cay Horstmann
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906, 12, 9)); // G. Hopper
        pq.add(LocalDate.of(1815, 12, 10)); // A. Lovelace
        pq.add(LocalDate.of(1903, 12, 3)); // J. von Neumann
        pq.add(LocalDate.of(1910, 6, 22)); // K. Zuse

        System.out.println("Iterating over elements...");
        for (LocalDate date : pq) {
            System.out.println(date);
        }
        System.out.println("Removing elements...");
        while(!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
}
