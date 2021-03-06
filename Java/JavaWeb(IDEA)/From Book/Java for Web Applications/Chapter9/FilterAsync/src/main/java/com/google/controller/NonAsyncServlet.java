package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 非异步情况。
 *
 * @author wrox, Liao
 * @date 2021-4-18
 */
@WebServlet(
        name = "NonAsyncServlet",
        urlPatterns = {"/regular"}
)
public class NonAsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("Entering NonAsyncServlet.doGet(). ");
        request.getRequestDispatcher("/WEB-INF/jsp/view/nonAsync.jsp").forward(request, response);
        System.out.println("Leaving NonAsyncServlet.doGet(). ");
    }
}
