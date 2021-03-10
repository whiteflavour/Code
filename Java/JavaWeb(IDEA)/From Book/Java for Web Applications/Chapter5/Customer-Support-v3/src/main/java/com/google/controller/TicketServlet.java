package com.google.controller;

import com.google.model.Ticket;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"}
)
public class TicketServlet extends HttpServlet {
    private volatile Integer DEFAULT_ID = 0;
    private Map<Integer, Ticket> ticketDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getAttribute("action").toString();
        if (action == null) {
            action = "list";
        }
        switch (action) {
            case "create":
                ticketForm(request, response);
                break;
            case "view":
                viewTicket(request, response);
                break;
            case "list":
            default:
                listTickets(request, response);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getAttribute("action").toString();
        if (action == null) {

        }

        switch (action) {
            case "create":
                createTicket(request, response);
        }
    }

    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ticketDatabase", ticketDatabase);
        request.getRequestDispatcher("/WEB-INF/view/listTickets.jsp").forward(request, response);
    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String customerName = request.getAttribute("customerName").toString();
        String subject = request.getAttribute("subject").toString();
        String body = request.getAttribute("body").toString();
        Ticket ticket = new Ticket(customerName, subject, body);

        synchronized (this) {
            ++DEFAULT_ID;
        }

        ticketDatabase.put(DEFAULT_ID, ticket);
        request.getRequestDispatcher("tickets?action=view&ticketId=" + DEFAULT_ID).forward(request, response);
    }

    private void viewTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO 尝试此语句的 request 是否与其他的是同一个 request
        request.setAttribute("ticketDatabase", ticketDatabase);
        request.getRequestDispatcher("/WEB-INF/view/viewTicket.jsp").forward(request, response);
    }

    private void ticketForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/ticketForm.jsp").forward(request, response);
    }
}
