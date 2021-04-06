package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 自定义 Tag 玩儿玩儿。
 *
 * @author wrox, Liao
 * @date 2021-3-28
 */
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
