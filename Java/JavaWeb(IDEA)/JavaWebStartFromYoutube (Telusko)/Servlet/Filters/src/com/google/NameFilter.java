package com.google;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Name Filter, name must be between 3 and 10 letters.
 *
 * @author Liao, Navin
 * @date 2021-2-4
 */
@WebFilter("/PrintIdAndName")
public class NameFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        System.out.println("Name Filter");

        String name = req.getParameter("name");

        if (name.length() > 2 && name.length() < 11) {
            chain.doFilter(req, resp);
        } else {
            out.print("Name is between 3 and 10 letters! ");
        }

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
