package com.google.io_test;

import org.junit.Test;

import java.io.*;

public class BufferedRWTest {
    @Test
    public void bufferedReaderTest() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file\\io_test\\i_test.txt"));
        int ch;
        while ((ch = bufferedReader.read()) != -1) {
            System.out.print((char) ch);
        }
        bufferedReader.close();
    }

    @Test
    public void bufferedWriterTest() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file\\io_test\\o6_test.txt"));
        char[] chars = "草泥马".toCharArray();
        bufferedWriter.write(chars);
        bufferedWriter.close();
    }

    @Test
    public void bufferedRWTest() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file\\io_test\\i_test.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file\\io_test\\o7_test.txt"));
        int ch;
        while ((ch = bufferedReader.read()) != -1) {
            bufferedWriter.write(ch);
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
