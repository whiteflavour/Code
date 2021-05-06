package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 抄过来玩儿玩儿。
 *
 * @author wrox, Liao
 * @date 2021-4-18
 */
@WebServlet(
        name = "compressedServlet",
        urlPatterns = {"/servlet"}
)
public class CompressedServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getOutputStream().println("This Servlet response may be compressed. ");
    }
}
