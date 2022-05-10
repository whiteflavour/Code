package com.google.io_test;

import org.junit.Test;

import java.io.*;

public class FileIOStreamTest {
    @Test
    public void inputTest() throws IOException {
        File file = new File("file\\io_test\\i_test.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        StringBuilder stringBuilder = new StringBuilder();
        int data = fileInputStream.read();
        while (data != -1) {
            stringBuilder.append((char)data);
            data = fileInputStream.read();
        }

        fileInputStream.close();
        System.out.println(stringBuilder);
    }

    @Test
    public void outputTest() throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("file\\io_test\\o_test.txt");
        byte[] data = "Go fuck yourself!!".getBytes();
        fileOutputStream.write(data);

        fileOutputStream.close();
    }

    @Test
    public void copyTest() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("F:\\1.docx");
        FileOutputStream fileOutputStream = new FileOutputStream("file\\io_test\\1.docx");
        byte[] buffer = new byte[1024];
        int bt;
        while ((bt = fileInputStream.read(buffer)) != -1) {
            // 不能使用 write(byte[]) 方法，否则打开文件时将会遇到错误。假设最后一次循环，一般不会刚好读完1024个字节数组的元素，即此缓冲未被填满，所以此时 bt 不为1024。如果不传入偏移量和长度，那么 write 方法会直接读取全部的缓冲，但是缓冲只有前一部分才有数据。
            fileOutputStream.write(buffer, 0, bt);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }
}
