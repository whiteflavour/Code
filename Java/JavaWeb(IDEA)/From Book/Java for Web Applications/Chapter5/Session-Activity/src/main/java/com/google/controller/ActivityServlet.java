package com.google.controller;

import com.google.model.PageVisit;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Vector;

/**
 * 看会话保留的时间，及其来源。
 *
 * @author Liao, wrox
 * @date 2021-3-9
 */
@WebServlet(
        name = "activityServlet",
        urlPatterns = {"/do/*"}
)
public class ActivityServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        recordSessionActivity(request);
        viewSessionActivity(request, response);
    }

    private void recordSessionActivity(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("activity") == null) {
            session.setAttribute("activity", new Vector<PageVisit>());
        }

        @SuppressWarnings("unchecked")
        Vector<PageVisit> visits = (Vector<PageVisit>)session.getAttribute("activity");

        if (!visits.isEmpty()) {
            visits.lastElement().setLeftTime(System.currentTimeMillis());
        }

        PageVisit currentVisit = new PageVisit();
        currentVisit.setEnterTime(System.currentTimeMillis());

        if (request.getQueryString() == null) {
            currentVisit.setRequest(request.getRequestURI());
        } else {
            currentVisit.setRequest(request.getRequestURI() + "?" + request.getQueryString());
        }

        try {
            InetAddress ipAddress = InetAddress.getByName(request.getRemoteHost());
            currentVisit.setIpAddress(ipAddress);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        visits.add(currentVisit);
    }

    private void viewSessionActivity(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/viewSessionActivity.jsp").forward(request, response);
    }
}
