package com.google.controller;

import com.google.dao.LoginDao;
import com.google.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * 登录控制器，一个 Servlet，用于检验用户输入的用户名与密码是否匹配。若匹配，则跳到 welcome 页面，否则继续在登录页面。
 *
 * @author Liao, Navin
 * @date 2021-2-9
 */
@WebServlet("/Login")
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 调用数据库连接类
        LoginDao dao = new LoginDao();
        // 检查用户输入的用户名与密码是否匹配，即：是否存在于数据库中，若存在，则执行 if 中的语句。
        if (dao.checkInfo(username, password)) {
            Student student = new Student(username);

            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("welcome.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
