package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(
        name = "MyServlet",
        urlPatterns = {"/index"}
)
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String view = "hello";
        request.getRequestDispatcher("/WEB-INF/jsp/view/" + view + ".jsp").forward(request, response);
    }
}
