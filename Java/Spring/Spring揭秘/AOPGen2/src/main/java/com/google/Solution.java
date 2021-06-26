package com.google;

public class Solution {
    public boolean isValid(String s) {
        // 用栈
        if (s.length() % 2 != 0) {
            return false;
        }
        while (s.contains("{}") || s.contains("()") || s.contains("[]")) {
            s = s.replace("{}", "")
                    .replace("[]", "")
                    .replace("()", "");
        }
        return s.length() == 0;
    }
}