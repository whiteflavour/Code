package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * 异步情况。
 *
 * @author wrox, Liao
 * @date 2021-4-18
 */
@WebServlet(
        name = "AsyncServlet",
        urlPatterns = {"/async"},
        asyncSupported = true
)
public class AsyncServlet extends HttpServlet {
    private volatile int ID = 0;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int id;
        synchronized (AsyncServlet.class) {
            id = ++ID;
        }
        long timeout = (request.getParameter("timeout") == null) ? 10_000L : Long.parseLong(request.getParameter("timeout"));
        System.out.println("Entering AsyncServlet.doGet. Request ID: " + id + ", isAsyncStarted = " + request.isAsyncStarted());
        final AsyncContext context = (request.getParameter("unwrap") != null) ? request.startAsync() : request.startAsync(request, response);
        context.setTimeout(timeout);

        System.out.println("Starting asynchronous thread. Request ID: " + id + ". ");

        AsyncThread thread = new AsyncThread(id, context);

        // 开启异步线程
        context.start(thread::doWork);

        System.out.println("Leaving AsyncServlet.doGet(). Request ID = " + id + ", isAsyncStarted = " + request.isAsyncStarted());
    }

    private static class AsyncThread {
        private final int id;
        private final AsyncContext context;

        public AsyncThread(int id, AsyncContext context) {
            this.id = id;
            this.context = context;
        }

        public void doWork() {
            System.out.println("Asynchronous thread started. Request ID: " + this.id + ".");

            try {
                Thread.sleep(5_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            HttpServletRequest request = (HttpServletRequest) this.context.getRequest();
            System.out.println("Done sleeping. Request ID = " + this.id + ", URL = " + request.getRequestURL() + ". ");

            this.context.dispatch("/WEB-INF/jsp/view/async.jsp");

            System.out.println("Asynchronous thread completed. Request ID = " + this.id + ". ");
        }
    }
}
