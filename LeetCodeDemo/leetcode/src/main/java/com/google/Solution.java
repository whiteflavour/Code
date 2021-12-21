package com.google;

import java.util.*;

public class Solution {
    public int majorityElement(int[] num) {
        int count = 1, candidate = num[0];
        for (int i = 1; i < num.length; ++i) {
            if (count == 0) {
                candidate = num[i];
                ++count;
            } else if (candidate == num[i]) {
                ++count;
            } else {
                --count;
            }
        }
        return candidate;
    }
}