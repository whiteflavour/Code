package com.google;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * A Servlet, which print your limited name and id.
 *
 * @author Liao, Navin
 * @date 2021-2-4
 */
@WebServlet("/PrintIdAndName")
public class MyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("My Servlet");

        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");

        PrintWriter out = response.getWriter();

        out.print("Your id is : " + id + "\nYour name is : " + name + "\n");
    }
}
