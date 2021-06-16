package com.google;

public class Solution {
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        /*
          将 s 转换为对应的整数
         */
        long longOfS = 0;
        for (int i = 0; i < s.length(); ++i) {
            // 去掉连续的两个匹配的括号
            if (i + 1 < s.length() && ((symbolsToInt(s.charAt(i)) % 2 == 0) && ((symbolsToInt(s.charAt(i)) + 1) == symbolsToInt(s.charAt(i + 1))))) {
                ++i;
                continue;
            }
            longOfS = longOfS * 10 + symbolsToInt(s.charAt(i));
        }
        System.out.println(longOfS);
        // 后半部分括号转换为对应的数字的值
        long endedMidNums = 0;
        boolean isAllSymbolsSame = false;
        while (longOfS > endedMidNums) {
            // 括号对应的值为奇数才 -1
            long remainder = longOfS % 10;
            boolean isRemainderOdd = remainder % 2 != 0;
            /*
              排除全为相同括号的情况
             */
            if (!isRemainderOdd) {
                isAllSymbolsSame = true;
            }
            endedMidNums = endedMidNums * 10 + (isRemainderOdd ? remainder - 1 : remainder);
            longOfS /= 10;
        }
        return longOfS == endedMidNums && !isAllSymbolsSame;
    }

    public int symbolsToInt(char symbol) {
        int mappedNum = 0;
        switch (symbol) {
            case '(':
                mappedNum = 2;
                break;
            case ')':
                mappedNum = 3;
                break;
            case '{':
                mappedNum = 4;
                break;
            case '}':
                mappedNum = 5;
                break;
            case '[':
                mappedNum = 6;
                break;
            case ']':
                mappedNum = 7;
                break;
        }
        return mappedNum;
    }
}
