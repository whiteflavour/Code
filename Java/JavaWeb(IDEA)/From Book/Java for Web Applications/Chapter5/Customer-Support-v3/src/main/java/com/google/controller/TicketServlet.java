package com.google.controller;

import com.google.model.Attachment;
import com.google.model.Ticket;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, // 5MB
        maxFileSize = 20_971_520, // 20MB
        maxRequestSize = 41_943_040 // 40MB
)
public class TicketServlet extends HttpServlet {
    private volatile int DEFAULT_ID = 0;
    private Map<Integer, Ticket> ticketDatabase = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("username") == null) {
            response.sendRedirect("login");
            // 防止重定向之后程序继续向下执行，产生 IllegalStateException
            return;
        }

        String action = request.getParameter("action");
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
            case "download":
                downloadAttachment(request, response);
                break;
            case "list":
            default:
                listTickets(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createTicket(request, response);
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

    private void listTickets(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("ticketDatabase", ticketDatabase);
        request.getRequestDispatcher("/WEB-INF/view/listTickets.jsp").forward(request, response);
    }

    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 解决 multipart/form-data 、 application/x-www-form-urlencoded 中文乱码问题
        String customerName = new String(request.getParameter("customerName").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String subject = new String(request.getParameter("subject").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        String body = new String(request.getParameter("body").getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
        Ticket ticket = new Ticket(customerName, subject, body);
        Part filePart = request.getPart("file1");
        if (filePart != null && filePart.getSize() > 0) {
            Attachment attachment = this.processAttachment(filePart);
            ticket.addAttachment(attachment);
        }

        synchronized (this) {
            ++DEFAULT_ID;
            ticketDatabase.put(DEFAULT_ID, ticket);
        }

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

    private void downloadAttachment(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int ticketId = Integer.parseInt(request.getParameter("ticketId"));
        if (ticketId < 1) {
            request.getRequestDispatcher("/tickets?action=create").forward(request, response);
        } else {
            Ticket ticket = ticketDatabase.get(ticketId);
            String attachmentName = request.getParameter("attachmentName");
            Attachment attachment = ticket.getAttachment(attachmentName);
            response.setHeader("Content-Disposition", "attachment; filename=" + attachmentName);
            response.setContentType("application/octet-stream");

            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(attachment.getContents());
        }
    }

    private Attachment processAttachment(Part filePart) throws IOException, ServletException {
        Attachment attachment = new Attachment();
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int read;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        attachment.setName(filePart.getSubmittedFileName());
        attachment.setContents(outputStream.toByteArray());
        return attachment;
    }
}
