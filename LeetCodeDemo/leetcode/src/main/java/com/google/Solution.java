package com.google;

import java.math.BigInteger;
import java.util.*;

public class Solution {
    public int trailingZeroes(int n) {
        int tailZeros = 0;
        for (int i = 5; n / i > 0; i *= 5) {
            tailZeros += n / i;
        }
        return tailZeros;
    }
}