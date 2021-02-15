package com.google.file_test;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class FileTest {
    @Test
    public void test() throws IOException {
        File dir = new File("F:\\IDEAFiles\\CoreJavaOne\\src\\com\\corejavaone\\demo");
        String[] dirList = dir.list();
        for (String str : dirList) {
            System.out.println(str);
        }
        System.out.println("dir = " + dir);
    }
}
