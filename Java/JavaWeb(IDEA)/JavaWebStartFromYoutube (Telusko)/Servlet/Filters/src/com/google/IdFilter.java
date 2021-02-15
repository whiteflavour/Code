package com.google;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * ID Filter, id must bigger than 0.
 *
 * @author Liao, Navin
 * @date 2021-2-4
 */
@WebFilter("/PrintIdAndName")
public class IdFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        System.out.println("ID Filter");

        int id = Integer.parseInt(req.getParameter("id"));

        if (id > 0) {
            chain.doFilter(req, resp);
        } else {
            out.print("Id can't be negative! \n");
        }


    }

    public void init(FilterConfig config) throws ServletException {

    }

}
