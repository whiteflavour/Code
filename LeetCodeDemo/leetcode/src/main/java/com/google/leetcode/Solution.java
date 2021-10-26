package com.google.leetcode;

import java.util.*;

class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode pre = head;
        ListNode cur = head.next;
        ListNode ordered = head;
        ListNode orderedPre = dummy;
        while (cur != null) {
            while (cur != null && ordered != cur) {
                if (cur.val < ordered.val) {
                    pre.next = cur.next;
                    cur.next = orderedPre.next;
                    orderedPre.next = cur;
                    if (ordered == head) {
                        head = cur;
                        dummy.next = cur;
                    }
                    orderedPre = dummy;
                    ordered = head;
                    cur = pre.next;
                } else {
                    orderedPre = orderedPre.next;
                    ordered = ordered.next;
                    if (ordered == cur) {
                        pre = pre.next;
                        cur = cur.next;
                        orderedPre = dummy;
                        ordered = head;
                    }
                }
            }
        }
        return dummy.next;
    }
}