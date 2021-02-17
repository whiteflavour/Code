package com.google.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登出控制类，用于退出用户登录后清除浏览器缓存，避免退出后按 返回键 还能继续回到登录后的页面的现象。清除缓存后，能够避免被黑客盗取信息，此页面相对安全，于是也叫做安全页面。
 *
 * @author Liao, Navin
 * @date 2021-2-9
 */
@WebServlet("/Logout")
public class LogoutController extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        // 清除 session 中设置过的属性，只要设置了属性，就必须清除。
        session.removeAttribute("student");
        // 使该 session 失效，清除属性后调用。
        session.invalidate();

        response.sendRedirect("login.jsp");
    }
}
