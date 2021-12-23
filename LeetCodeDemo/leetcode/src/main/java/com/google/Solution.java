package com.google;

import java.util.*;

public class Solution {
    public int trailingZeroes(int n) {
        long product = partition(1, n);
        int tailZeros = 0;
        while (product % 10 == 0) {
            ++tailZeros;
            product /= 10;
        }
        return tailZeros;
    }

    public long partition(int left, int right) {
        if (left >= right) {
            return left == right ? left : 1;
        }
        int mid = left + (right - left >> 1);
        if (left + 1 == right) {
            return (long) left * right;
        }
        long leftProduct = partition(left, mid);
        long rightProduct = partition(mid + 1, right);
        return leftProduct * rightProduct;
    }
}