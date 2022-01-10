package com.google;

import java.util.*;

public class Solution {
    static final int subLen = 10;
    Map<Character, Integer> dnaToBin = new HashMap<Character, Integer>() {{
        put('A', 0);
        put('C', 1);
        put('G', 2);
        put('T', 3);
    }};

    public List<String> findRepeatedDnaSequences(String s) {
        List<String> repeatedSubDna = new ArrayList<>();
        Map<Integer, Integer> subDnaCounter = new HashMap<>();
        int x = 0;
        for (int i = 0; i < subLen - 1; ++i) {
            x = (x << 2) | (dnaToBin.get(s.charAt(i)));
        }
        for (int i = 0; i <= s.length() - subLen; ++i) {
            x = (x << 2 | dnaToBin.get(s.charAt(i + subLen - 1))) & ((1 << 2 * subLen) - 1);
            subDnaCounter.put(x, subDnaCounter.getOrDefault(x, 0) + 1);
            if (subDnaCounter.get(x) == 2) {
                repeatedSubDna.add(s.substring(i, i + subLen));
            }
        }
        return repeatedSubDna;
    }
}
