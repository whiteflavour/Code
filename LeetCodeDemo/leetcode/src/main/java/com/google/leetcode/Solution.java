package com.google.leetcode;

import java.util.*;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int left = 0;
        List<String> ans = new ArrayList<>();

        while (left < words.length) {
            int right = findRight(words, left, maxWidth);
            ans.add(justify(words, left, right, maxWidth));
            left = right + 1;
        }

        return ans;
    }

    private int findRight(String[] words, int left, int maxWidth) {
        int right = left;
        int sum = 0;

        for (; right < words.length; ++right) {
            sum += words[right].length() + 1;
            if (sum >= maxWidth) {
                return right - 1;
            }
        }

        return right - 1;
    }

    private String justify(String[] words, int left, int right, int maxWidth) {
        if (left == right) {
            return padResult(words[left], maxWidth);
        }

        StringBuilder line = new StringBuilder();
        boolean isLastLine = right == words.length - 1;
        int spaces = maxWidth - wordsLength(words, left, right);
        int spacesToInsert = right - left;

        String space = isLastLine ? "" : blank(spaces / spacesToInsert);
        int remainder = isLastLine? 0 : spaces % spacesToInsert;

        for (int i = left; i <= right; ++i) {
            line.append(words[i]).append(space)
                    .append(remainder-- > 0 ? " " : "");
        }

        return padResult(String.valueOf(line).trim(), maxWidth);
    }

    private String padResult(String result, int maxWidth) {
        return result + blank(maxWidth - result.length());
    }

    private int wordsLength(String[] words, int left, int right) {
        int sum = 0;
        for (int i = left; i <= right; ++i) {
            sum += words[i].length();
        }
        return sum;
    }

    private String blank(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num; ++i) {
            sb.append(" ");
        }
        return String.valueOf(sb);
    }
}