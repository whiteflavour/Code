package com.google.filter;

import com.google.dao.LoginDao;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        LoginDao loginDao = new LoginDao();

        if (loginDao.isMatching(username, password)) {
            chain.doFilter(request, response);
        } else {
            // 不能使用 RequestDispatcher
            ((HttpServletResponse)response).sendRedirect("index.jsp");
        }
    }
}
