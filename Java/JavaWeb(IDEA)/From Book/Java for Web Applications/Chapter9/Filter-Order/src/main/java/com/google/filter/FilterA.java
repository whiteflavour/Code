package com.google.filter;

import javax.servlet.*;
import java.io.IOException;

public class FilterA implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Entering FilterA.doFilter()");
        chain.doFilter(request, response);
        System.out.println("Leaving FilterA.doFilter()");
    }
}
