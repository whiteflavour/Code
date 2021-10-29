package com.google.leetcode;

import java.util.*;

public class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new LinkedList<>();
        for (String token : tokens) {
            if (token.length() >  1 || Character.isDigit(token.charAt(0))) {
                stack.push(token);
            } else {
                int num1 = Integer.parseInt(stack.pop());
                int num2 = Integer.parseInt(stack.pop());
                switch (token) {
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num2 - num1));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num2 / num1));
                        break;
                }
            }
        }
        return Integer.getInteger(stack.pop());
    }
}