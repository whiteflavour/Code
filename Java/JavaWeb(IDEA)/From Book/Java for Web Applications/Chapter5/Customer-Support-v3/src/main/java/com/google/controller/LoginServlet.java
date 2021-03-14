package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Login Servlet.
 *
 * @author Liao
 * @date 2021-3-14
 */
@WebServlet(
        name = "loginServlet",
        urlPatterns = {"/login"}
)
public class LoginServlet extends HttpServlet {
    private Map<String, String> userDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        userDatabase.put("Fuck", "qnmd");
        userDatabase.put("Rose", "r");
        userDatabase.put("Tom", "t");
        userDatabase.put("Jack", "j");
        userDatabase.put("Jerry", "jj");

        request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (!(userDatabase.containsKey(username))) {
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
        if (userDatabase.get(username) == null) {
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }
        if (!(password.equals(userDatabase.get(username)))) {
            request.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(request, response);
        }

        HttpSession session = request.getSession();
        session.setAttribute("username", username);
        request.getRequestDispatcher("tickets").forward(request, response);
    }
}
