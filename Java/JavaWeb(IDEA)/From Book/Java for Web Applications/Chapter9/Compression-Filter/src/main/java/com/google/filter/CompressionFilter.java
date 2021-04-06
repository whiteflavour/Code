package com.google.filter;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.Response;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.zip.GZIPOutputStream;

@WebFilter(filterName = "CompressionFilter")
public class CompressionFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        if (((HttpServletRequest)request).getHeader("Accept-Encoding").contains("gzip")) {
            System.out.println("Encoding requested. ");
            ((HttpServletResponse)response).setHeader("Content-Encoding", "gzip");
            ResponseWrapper wrapper = new ResponseWrapper();
        }
    }

    private static class ResponseWrapper extends HttpServletResponseWrapper {
        private GZIPServletOutputStream outputStream;
        private PrintWriter writer;

        public ResponseWrapper(HttpServletResponse response) {
            super(response);
            // TODO
        }
    }

    private static class GZIPServletOutputStream extends ServletOutputStream {
        private final ServletOutputStream servletOutputStream;
        private final GZIPOutputStream gzipStream;

        public GZIPServletOutputStream(ServletOutputStream servletOutputStream) throws IOException {
            this.servletOutputStream = servletOutputStream;
            this.gzipStream = new GZIPOutputStream(servletOutputStream);
        }

        @Override
        public boolean isReady() {
            return this.servletOutputStream.isReady();
        }

        @Override
        public void setWriteListener(WriteListener writeListener) {
            this.servletOutputStream.setWriteListener(writeListener);
        }

        @Override
        public void write(int b) throws IOException {
            this.gzipStream.write(b);
        }

        @Override
        public void close() throws IOException {
            this.gzipStream.close();
        }

        @Override
        public void flush() throws IOException {
            this.gzipStream.flush();
        }

        public void finish() throws IOException {
            this.gzipStream.finish();
        }
    }
}
