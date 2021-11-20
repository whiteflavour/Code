package com.google;

import com.google.controller.StudentController;
import com.google.model.Student;
import com.google.view.StudentView;

public class MVCPatternDemo {
    public static void main(String[] args) {
        Student model = retrieveStudentFromDatabase();
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.updateView();
        controller.setStudentName("Tom");
        controller.updateView();
    }

    public static Student retrieveStudentFromDatabase() {
        return new Student("1", "Rose");
    }
}
