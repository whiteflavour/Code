package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name = "servletOne",
        urlPatterns = {"/servletOne"}
)
public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("Entering ServletOne.doGet()");
        PrintWriter out = response.getWriter();
        out.print("Servlet One");
        System.out.println("Leaving ServletOne.doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
