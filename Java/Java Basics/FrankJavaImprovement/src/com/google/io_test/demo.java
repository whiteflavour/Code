package com.google.io_test;

import org.junit.Test;

import java.io.*;

public class demo {
    @Test
    public void demo1() throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("file\\io_test\\o_test.txt"));
        bufferedWriter.write("Go fuck");
        bufferedWriter.newLine();
        bufferedWriter.write("yourself");
        bufferedWriter.newLine();
        bufferedWriter.write("!!");
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    @Test
    public void demo2() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("file\\io_test\\i_test.txt"));
        String str;
        while ((str = bufferedReader.readLine()) != null) {
            System.out.println(str);
        }
    }

    @Test
    public void lombokDemo() {
        Student student = new Student(10, "fuck", 1);
        System.out.println(student.getName());
    }
}
