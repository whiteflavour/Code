package com.google;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // 双指针法的思路：
        ListNode left = head;
        ListNode right = head.next;
        while (right.next != null) {
            // 将右指针跳过重复值，移动到非重复值上
            while (left.val == right.val) {
                right = right.next;
            }
            // 将左指针直接指向非重复值的右指针，
            // 避免每次发现重复值都指一下，提高效率
            if (left.next != right) {
                left.next = right;
            }
            // 移动左指针
            left = left.next;
            // 移动右指针
            if (right.next != null) {
                right = right.next;
            }
        }
        return head;
    }
}
