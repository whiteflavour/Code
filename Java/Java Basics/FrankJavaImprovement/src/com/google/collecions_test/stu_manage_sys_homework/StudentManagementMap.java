package com.google.collecions_test.stu_manage_sys_homework;

import java.util.*;

/**
 * Student management system, using Map. ———— Homework of Frank's Java implement course.
 *
 * @date 2021-1-19
 * @author Liao
 */
public class StudentManagementMap {
    private int ID = 1;
    private HashMap<Integer, String> student = new HashMap<>();

    /**
     * Insert a student whose name is not null.
     * @param name the student's name
     */
    public void insertStudent(String name) {
        if (name != null) {
//            Student stu = new Student(ID, name);
            student.put(ID, name);
            System.out.println("Added a student: ID: " + ID + ", Name: " + name);
            // 每插入一个学生，ID + 1 。
            ++ID;
        } else {
            System.out.println("Sorry, student's name can't be null! ");
        }
    }

    public void deleteStudent(int stuID) {
        if (student.containsKey(stuID)) {
            System.out.println("Deleted a student: ID: " + stuID + ", Name: " + student.get(stuID));
            student.remove(stuID);
        } else {
            System.out.println("No such student. ");
        }
    }

    public void updateStudent(int stuID, String newName) {
        if (student.containsKey(stuID)) {
            if (newName != null) {
                student.replace(stuID, newName);
                System.out.println("Updated a student: ID: " + stuID + ", New Name: " + student.get(stuID));
            } else {
                System.out.println("Name can't be null. ");
            }
        } else {
            System.out.println("No such student. ");
        }
    }

    /**
     * Query a specific student by stuID.
     * @param stuID the student's stuID
     */
    public void showStudent(int stuID) {
        if (student.containsKey(stuID)) {
            System.out.println("ID: " + stuID + ", Name: " + student.get(stuID));
        } else {
            System.out.println("No such student. ");
        }
    }

    /**
     * Show all students in the system.
     */
    public void showAll() {
        System.out.println(student);
    }
}
