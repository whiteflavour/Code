package com.google.listener;

import com.google.filter.LoginFilter;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebListener
public class HomeListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public HomeListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        FilterRegistration.Dynamic registration = context.addFilter("loginFilter", new LoginFilter());
        // 注意 URL 路径
        registration.addMappingForUrlPatterns(null, false, "/login");
    }
}
