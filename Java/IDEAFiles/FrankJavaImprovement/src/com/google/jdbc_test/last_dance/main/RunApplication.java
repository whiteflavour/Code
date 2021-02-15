package com.google.jdbc_test.last_dance.main;

import com.google.jdbc_test.last_dance.service.StudentService;
import com.google.jdbc_test.util.JDBCUtilsPreparedStatement;

import java.util.Scanner;

/**
 * Start the Student Management System.
 *
 * @author Liao, Frank
 * @date 2021-1-31
 */
public class RunApplication {
    public static void main(String[] args) {
        init();
    }

    public static void init() {
        System.out.println("------------------Welcome to Student Management System-------------------");

        functionService();
    }

    /**
     * 显示功能，并分别调用其对应的函数。
     */
    public static void functionService() {
        Scanner scanner = new Scanner(System.in);
        // 用于选择功能
        int functionNumber = 0;

        try {
            while (true) {
                System.out.println();
                System.out.println("---------There are the functions--------");
                System.out.println("1. select all");
                System.out.println("2. select by id");
                System.out.println("3. insert");
                System.out.println("4. delete all");
                System.out.println("5. delete by id");
                System.out.println("6. update name and age");
                System.out.println("7. update name");
                System.out.println("8. update age");
                System.out.println("9. quit");
                System.out.println("请输入要使用的功能前面对应的数字：");
                functionNumber = scanner.nextInt();
                switch (functionNumber) {
                    case 1:
                        StudentService.selectAll();
                        break;
                    case 2:
                        StudentService.selectById();
                        break;
                    case 3:
                        System.out.println(StudentService.insert());
                        break;
                    case 4:
                        System.out.println(StudentService.truncate());
                        break;
                    case 5:
                        System.out.println(StudentService.delete());
                        break;
                    case 6:
                        System.out.println(StudentService.update());
                        break;
                    case 7:
                        System.out.println(StudentService.updateName());
                        break;
                    case 8:
                        System.out.println(StudentService.updateAge());
                        break;
                    case 9:
                        System.exit(0);
                        break;
                    default:
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtilsPreparedStatement.close(StudentService.getConnection(), StudentService.getPreparedStatement(), StudentService.getResultSet());
        }
    }
}
