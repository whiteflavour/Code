package com.google.filter;

import org.apache.commons.lang3.time.StopWatch;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

@WebFilter(filterName = "RequestLogFilter")
public class RequestLogFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        Instant time = Instant.now();
        StopWatch timer = new StopWatch();

        try{
            timer.start();
            chain.doFilter(request, response);
        } finally {
            timer.stop();
            HttpServletRequest in = (HttpServletRequest) request;
            HttpServletResponse out = (HttpServletResponse) response;

            String length = out.getHeader("Content-Length");

            if (length == null || length.length() == 0) {
                length = "-";
            }

            System.out.println(in.getRemoteAddr() + "- -[" + time + "]\"" + in.getMethod() + " " + in.getRequestURI() + " " + in.getProtocol() + "\" " + out.getStatus() + " " + length + " " + timer);
        }
    }
}
