package com.google;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class MyServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {

        // 使 <br> 在浏览器中显示 HTML 中的换行
        res.setContentType("text/html");

        PrintWriter out = res.getWriter();
        out.print("Hi<br>");

        // ServletConfig
        ServletConfig config = getServletConfig();
        String str = config.getInitParameter("name");

        /*// Servlet Context
//        ServletContext context = req.getServletContext();
        // 相当于上面这句
        ServletContext context = getServletContext();

        String str = context.getInitParameter("Phone");*/

        out.println(str);
    }
}

