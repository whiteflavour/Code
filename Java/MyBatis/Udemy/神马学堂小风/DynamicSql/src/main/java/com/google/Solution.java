package com.google;

public class Solution {
    public int strStr(String haystack, String needle) {
        // 官方解法2，KMP 算法
        if (needle.equals("")) {
            return 0;
        }

        // 部分匹配表 - 阮一峰 KMP 算法 Blog
        int[] pi = new int[needle.length()];
        // 填满部分匹配表
        for (int i = 1, j = 0; i < needle.length(); ++i) {
            // 若不相等，看已经匹配了的前缀对应的匹配表的值，
            // 若不为 0，则说明该字符前面的字母也是和它匹配的，
            // 且和它一样，所以如果下一个字符和该字符相等，
            // 则说明下一个字符和该字符及其前面匹配的字符相等，
            // 所以下一个相等字符 j 会 +1
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                ++j;
            }
            pi[i] = j;
        }

        // 开始进行搜索
        for (int i = 0, j = 0; i < haystack.length(); ++i) {
            // 与前一个 while 语句块类似，若下一个字符与该字符已经
            // 匹配的前缀相等，那么直接跳过已经匹配的字符。++j 等价于
            // 将 needle 在 haystack 下方往后移动。- 参考阮一峰 KMP
            // 算法 Blog 的匹配流程。
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++j;
            }
            if (j == needle.length()) {
                return i - j + 1;
            }
        }
        return -1;
    }
}
