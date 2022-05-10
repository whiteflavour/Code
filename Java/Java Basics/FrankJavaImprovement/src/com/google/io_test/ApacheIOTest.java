package com.google.io_test;

import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class ApacheIOTest {
    @Test
    public void fileUtilsTest() throws IOException {
        File srcfile = new File("file\\io_test\\i_test.txt");
        File destfile = new File("file\\io_test\\1.txt");
        String str = "Go f";
//        FileUtils.copyFile(srcfile, destfile);
        System.out.println(FileUtils.sizeOf(srcfile));
//        FileUtils.write(destfile, str, "UTF-8");
//        FileUtils.writeStringToFile(destfile, "uck you!", "UTF-8", true);

        Student fuki = new Student(18, "Fuki", 2);
        Student gogo = new Student(19, "gogo", 3);

        ArrayList<Student> students = new ArrayList<>();
        students.add(fuki);
        students.add(gogo);
        FileUtils.writeLines(destfile, Collections.singleton(new ArrayList<>().add(fuki)), true);
    }
}
