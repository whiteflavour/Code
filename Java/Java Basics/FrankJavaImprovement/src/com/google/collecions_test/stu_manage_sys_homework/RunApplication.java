package com.google.collecions_test.stu_manage_sys_homework;

/**
 * Running the StudentManagementMap class.
 *
 * @date 2021-1-20
 * @author Liao
 */
public class RunApplication {
    private static StudentManagementMap studentManagementMap = new StudentManagementMap();

    public static void main(String[] args) {
        runApp();
    }

    public static void runApp() {
        insertStu("Tom");
        insertStu("Jerry");
        insertStu("Dick");
        insertStu("Fuck");
        insertStu("傻逼");
        insertStu("Shit");
        insertStu("Red");
        insertStu("狗逼");
        insertStu("菜逼");
        insertStu("垃圾");
        insertStu("狗屎");
        insertStu("菜鸡");
        insertStu("Rose");

        showAll();

        deleteStu(2);

        showAll();

        showStu(5);

        showAll();

        updateStu(3, "屌");

        showAll();
    }

    public static void insertStu(String name) {
        studentManagementMap.insertStudent(name);
    }

    public static void deleteStu(int stuID) {
        studentManagementMap.deleteStudent(stuID);
    }

    public static void updateStu(int stuID, String newName) {
        studentManagementMap.updateStudent(stuID, newName);
    }

    public static void showStu(int stuID) {
        studentManagementMap.showStudent(stuID);
    }

    /**
     * Show all students in the system.
     */
    public static void showAll() {
        studentManagementMap.showAll();
    }
}
