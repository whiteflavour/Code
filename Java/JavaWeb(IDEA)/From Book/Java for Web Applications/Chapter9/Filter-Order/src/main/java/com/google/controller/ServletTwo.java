package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "ServletTwo",
        urlPatterns = {"/servletTwo"}
)
public class ServletTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entering ServletTwo.doGet()");
        response.getWriter().print("Servlet Two");
        System.out.println("Leaving ServletTwo.doGet()");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
