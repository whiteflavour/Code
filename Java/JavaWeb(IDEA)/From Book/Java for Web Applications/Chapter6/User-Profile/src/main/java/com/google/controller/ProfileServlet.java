package com.google.controller;

import com.google.model.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

/**
 * Profile and permissions of users.
 *
 * @author Liao, wrox
 * @date 2021-3-16
 */
@WebServlet(
        name = "profileServlet",
        urlPatterns = {"/profile"}
)
public class ProfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = new User(19384L, "Coder314", "John", "Smith");

        Map<String, Boolean> permissions = user.getPermissions();
        permissions.put("user", true);
        permissions.put("moderator", true);
        permissions.put("admin", false);

        request.setAttribute("user", user);
        request.getRequestDispatcher("/WEB-INF/jsp/view/profile.jsp").forward(request, response);
    }
}
