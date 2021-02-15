package com.google.io_test;

import org.junit.Test;

import java.io.*;

public class BufferedIOStreamTest {
    @Test
    public void bufferedInputStreamTest() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("file\\io_test\\i_test.txt"));
        int ch;
        while ((ch = bufferedInputStream.read()) != -1) {
            System.out.print((char)ch);
        }
        bufferedInputStream.close();
    }

    @Test
    public void bufferedOutputStreamTest() throws IOException {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("file\\io_test\\o2_test.txt"));
        byte[] bt = "Go fuck yourself!".getBytes();
        bufferedOutputStream.write(bt);
        bufferedOutputStream.close();
    }

    @Test
    public void bufferedCopyTest() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("file\\io_test\\i_test.txt"));
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("file\\io_test\\o3_test.txt"));
        int bt;
        while ((bt = bufferedInputStream.read()) != -1) {
            bufferedOutputStream.write((char)bt);
        }
        bufferedInputStream.close();
        bufferedOutputStream.close();
    }
}
