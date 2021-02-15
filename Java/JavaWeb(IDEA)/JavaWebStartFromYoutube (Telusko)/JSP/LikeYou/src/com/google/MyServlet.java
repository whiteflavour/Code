package com.google;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/LikeYou")
public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name1 = request.getParameter("name1");
        String name2 = request.getParameter("name2");

        String result = name1 + "喜欢" + name2;

        request.setAttribute("like", result);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("you.jsp");
        requestDispatcher.forward(request, response);
    }
}
