package com.google;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Use a Servlet to call another Servlet.
 * This is the calling Servlet.
 */
@WebServlet("/add")
public class AddServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        addNumber(req, res);
    }

    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        addNumber(req, res);
    }

    public void addNumber(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int numberA = Integer.parseInt(req.getParameter("num1"));
        int numberB = Integer.parseInt(req.getParameter("num2"));
        int k = numberA + numberB;

        // use Cookie
        Cookie cookie = new Cookie("k", k + "");
        res.addCookie(cookie);

        // use Session
        /*HttpSession session = req.getSession();
        session.setAttribute("k", k);*/

        res.sendRedirect("sq");

        // 在 URL 中获取 k 值
//        res.sendRedirect("sq?k=" + k);


        // 使用 RequestDispatcher
        /*req.setAttribute("sq", square);

        RequestDispatcher dispatcher = req.getRequestDispatcher("sq");
        dispatcher.forward(req, res);*/

/*        PrintWriter out = res.getWriter();
        out.println("The result is " + sum);*/
    }
}