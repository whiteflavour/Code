package com.google.io_test;

import org.junit.Test;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterTest {
    @Test
    public void fileReaderTest() throws IOException {
        FileReader fileReader = new FileReader("file\\io_test\\i_test.txt");
        int ch;
        while ((ch = fileReader.read()) != -1) {
            System.out.print((char)ch);
        }
        fileReader.close();
    }

    @Test
    public void fileWriterTest() throws IOException {
        FileWriter fileWriter = new FileWriter("file\\io_test\\04_test.txt");
        char[] chars = "Fuck you!!".toCharArray();
        fileWriter.write(chars);
        fileWriter.close();
    }

    @Test
    public void fileCopyTest() throws IOException {
        FileReader fileReader = new FileReader("file\\io_test\\i_test.txt");
        FileWriter fileWriter = new FileWriter("file\\io_test\\o5_test.txt");
        int ch;
        while ((ch = fileReader.read()) != -1) {
            fileWriter.write(ch);
        }
        fileReader.close();
        fileWriter.close();
    }
}
