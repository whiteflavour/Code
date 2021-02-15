package com.google;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(1, "Fucker"));
        students.add(new Student(2, "Tom"));
        students.add(new Student(3, "Jerry"));

        request.setAttribute("stus", students);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);

        /*PrintWriter out = response.getWriter();
        out.print("fuck");*/
    }
}
