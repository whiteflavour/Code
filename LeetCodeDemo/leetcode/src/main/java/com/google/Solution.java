package com.google;

import java.util.*;

public class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int ans = right & (right - 1);
        int bitAnd = ans;
        int counter = 1;
        while (left < bitAnd) {
            if (counter == 32) {
                return 0;
            }
            ans &= bitAnd - 1;
            bitAnd = ans;
            ++counter;
        }
        return ans;
    }
}