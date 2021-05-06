package com.google.filter;

import org.apache.commons.lang3.time.StopWatch;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.Instant;

/**
 * 日志过滤器，因为是编程配置，且比 CompressionFilter 更先配置，所以它比 CompressionFilter 先调用。
 * 每次调用，它会在控制台输出一些日志记录。
 *
 * @author wrox, Liao
 * @date 2021-4-18
 */
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
