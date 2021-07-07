package com.google.test;

import com.google.ListNode;
import com.google.Solution;
import org.junit.jupiter.api.Test;

public class SolutionTest {
    @Test
    public void someTest() {
        Solution solution = new Solution();
        ListNode head = new ListNode(1);
        ListNode tail = head;
        tail.next = new ListNode(1);
        tail = tail.next;
        tail.next = new ListNode(2);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        tail.next = new ListNode(3);
        tail = tail.next;
        head = solution.deleteDuplicates(head);
        while (head.next != null) {
            System.out.println(head.val);
            head = head.next;
        }
        System.out.println(head.val);
    }

    @Test
    public void otherTest() {
    }
}
