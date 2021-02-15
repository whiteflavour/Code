package com.google.junit;

import org.junit.Test;

public class StringBuilderTest {
    @Test
    public void demo() {
        StringBuilder stringBuilder = new StringBuilder();
        // 链式调用
        System.out.println(stringBuilder.append("Go").append(" Fuck").append(" Yourself!"));
    }

}
