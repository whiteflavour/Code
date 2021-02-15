package com.google.charset_test;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class CharsetTest {
    /**
     * Test the difference between UTF-8 and GBK.
     * @throws UnsupportedEncodingException
     */
    @Test
    public void charsetTest() throws UnsupportedEncodingException {
        byte[] bytes1 = "你好！".getBytes();
        byte[] bytes2 = "你好！".getBytes("GBK");
        System.out.println(Arrays.toString(bytes1));
        System.out.println(Arrays.toString(bytes2));
    }
}
