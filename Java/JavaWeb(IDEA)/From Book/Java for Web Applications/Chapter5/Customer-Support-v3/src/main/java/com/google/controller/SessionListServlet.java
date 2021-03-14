package com.google.controller;

import com.google.model.SessionRegistry;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * List sessions.
 *
 * @author Liao
 * @date 2021-3-14
 */
@WebServlet(
        name = "sessionListServlet",
        urlPatterns = "/sessions"
)
public class SessionListServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login");
            return;
        }

        request.setAttribute("sessionList", SessionRegistry.getSessions());
        request.setAttribute("numberOfSessions", SessionRegistry.getNumberOfSessions());
        request.getRequestDispatcher("/WEB-INF/view/sessions.jsp").forward(request, response);
    }
}
