package com.google.controller;

import com.google.model.Ticket;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 具有开票，评论功能，还能上传下载附件。有些步骤未完成。
 *
 * @author Liao
 * @date 2021-2-28
 */
@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
@MultipartConfig(
        fileSizeThreshold = 5_242_880, // 5MB
        maxFileSize = 20_971_520L, // 20MB
        maxRequestSize = 41_943_040 // 40MB
)
public class TicketServlet extends HttpServlet {
    private volatile Integer id = 0;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "create":
                createTicket(request, response);
                break;
            case "list":
            default:
                listTicket(out, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void listTicket(PrintWriter out, HttpServletResponse response) throws IOException {
        writeHeader(out, response);
        out.append("<h1>Tickets: </h1>\n")
                .append("<a href=\"tickets?action=create\">create ticket</a>\n");
        if (id < 1) {
            out.append("Nothing ...");
        } else {
            // TODO 遍历每个票据
            out.append("Ticket #").append(Character.highSurrogate(id)).append(" <a href=\"tickets?action=view&ticketId=\"").append(Character.highSurrogate(id)).append("</a> <br/>\n");
        }
        writeFooter(out);
    }

    public void createTicket(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String customerName = request.getParameter("customerName");
        String subject = request.getParameter("subject");
        String body = request.getParameter("body");
        Ticket ticket = new Ticket(customerName, subject, body);
        synchronized (this) {
            ++id;
        }
        response.sendRedirect("tickets?action=list");
    }

    public void showTicketForm(PrintWriter out) {
        out.append("<h1>Ticket #").append(Character.highSurrogate(id)).append("<h1>\n")
                .append("<form action=\"tickets\" method=\"post\" enctype=\"multipart/form-data\">\n")
                .append("<input type=\"hidden\" name=\"action\" value=\"create\">\n")
                .append("Your name: \n")
                .append("<input type=\"text\" name=\"customerName\"> <br/>\n")
                .append("Subject: <br/>\n")
                .append("<input type=\"text\" name=\"subject\"><br/>\n")
                .append("Body: <br/>\n")
                .append("<textarea name=\"body\" rows=\"5\" cols=\"30\"></textarea> <br/>\n")
                .append("<b>Attachments: </b> <br/>\n")
                .append("<input type=\"file\" name=\"file1\"><br/>\n")
                .append("<input type=\"submit\" value=\"Submit\">\n");
    }

    public void viewTicket(Ticket ticket) {
        // TODO 用一个 Map 来读取 ticket 的 id ，然后再用该 id 来创建一个 Ticket 对象，再进行下面的操作。
    }

    public void writeHeader(PrintWriter out, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("<meta charset=utf8>\n")
                .append("<title>Happy communication</title>\n")
                .append("</head>\n")
                .append("<body>");
    }

    public void writeFooter(PrintWriter out) {
        out.append("</body>\n")
                .append("</html>\n");
    }
}
