package com.google.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.IOException;

/**
 * 过滤器，看是否含有 wrapped 对象。
 *
 * @author wrox, Liao
 * @date 2021-4-18
 */
public class AnyRequestFilter implements Filter {
    private String name;

    public void init(FilterConfig config) throws ServletException {
        this.name = config.getFilterName();
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        System.out.println("Entering " + this.name + ".doFilter()");
        chain.doFilter(new HttpServletRequestWrapper((HttpServletRequest) request), new HttpServletResponseWrapper((HttpServletResponse) response));
        if (request.isAsyncSupported() && request.isAsyncStarted()) {
            AsyncContext context = request.getAsyncContext();
            System.out.println("Leaving " + this.name + ".doFilter(), async " + "context holds wrapped request/response = " + !context.hasOriginalRequestAndResponse());
        } else {
            System.out.println("Leaving " + this.name + ".doFilter()");
        }
    }
}
