package com.google.controller;

import com.google.dao.ShoppingDao;
import com.google.model.Attachment;
import com.google.model.Ticket;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 展示发票或者开发票，购买的物品及价格功能暂未实现，需要多个 Servlet 来完成该工作。
 *
 * @author Liao
 * @date 2021-2-26
 */
@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/ticket"},
        loadOnStartup = 1
)
public class TicketServlet extends HttpServlet {
    private static volatile BigInteger id = BigInteger.valueOf(0L);
    private ArrayList<Ticket> tickets = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();

        writeHeader(response);
        out.append("<meta charset=utf8>\n")
                .append("<title>Select</title>\n");
        writeBody(response);
        out.append("<form action=\"ticket\" method=\"POST\">\n")
                .append("Enter your name: ").append("<input type=\"text\" name=\"customerName\"> <br/>\n")
                .append("<input type=\"radio\" name=\"action\" value=\"create\">").append("create<br/>\n")
                .append("<input type=\"radio\" name=\"action\" value=\"view\">").append("view<br/>\n")
                .append("<input type=\"submit\" value=\"Submit\">\n");
        writeFooter(response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String customerName = request.getParameter("customerName");

        if (action == null) {
            action = "";
        }

        if (customerName == null) {
            customerName = "";
        }

        switch (action) {
            case "create":
                createTicket(customerName, request, response);
                break;
            case "view":
            default:
                showTicket(tickets, customerName, request, response);
        }
    }

    private void createTicket(String customerName, HttpServletRequest request, HttpServletResponse response) throws IOException {
//        shopping(response);
        Calendar calendar = new GregorianCalendar();
        Date date = calendar.getTime();
        Attachment objects = new Attachment();

        ShoppingDao shoppingDao = new ShoppingDao();

        /*String[] boughtThings = request.getParameterValues("goods");
        for (String objectName : boughtThings) {
            BigDecimal price = shoppingDao.getPrice(objectName);
            objects.addObject(objectName, price);
        }*/

        synchronized (this) {
            id = id.add(BigInteger.valueOf(1L));
        }

        Ticket ticket = new Ticket(id, customerName, objects, date);
        tickets.add(ticket);
        System.out.println("Create success! ");

        showTicket(tickets, customerName, request, response);
    }

    private void showTicket(ArrayList<Ticket> tickets, String customerName, HttpServletRequest request, HttpServletResponse response) throws IOException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if (id.intValue() < 1) {
            response.getWriter().print("Nothing ... ");
        } else {
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();

            ShoppingDao shoppingDao = new ShoppingDao();

            int i;
            for (i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getCustomerName().equals(customerName)) {
                    break;
                } else {
                    i = -1;
                }
            }
            String[] boughtThings;
            if (i > -1) {
                Ticket ticket = tickets.get(i);
                boughtThings = ticket.getObjects().keySet().toArray(new String[0]);

                writeHeader(response);
                out.append("<meta charset=utf8>")
                        .append("<title>Your ticket</title>\n");
                writeBody(response);
                out.append("At: ").append(ticket.getMarketName()).append("<br/>")
                        .append("Ticket id: ").append(ticket.getId().toString()).append("<br/>")
                        .append("Your name: ").append(ticket.getCustomerName()).append("<br/>")
                        .append("Things you've bought: \n")
                        .append("<ul>\n");
                for (String thing :
                        boughtThings) {
                    BigDecimal price = shoppingDao.getPrice(thing);
                    out.append("<li>thing: ").append(String.valueOf(price)).append(" </li>\n");
                }
                out.append("</ul>\n<br/>")
                        .append("Date: ").append(simpleDateFormat.format(ticket.getDate()));
                writeFooter(response);
            } else {
                out.print("You didn't buy anything yet! ");
            }
        }
    }

    /*private void shopping(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        writeHeader(response);
        out.append("<meta charset=utf8>")
                .append("<title>Happy Shopping</title> <br/>\n");
        writeBody(response);
        out.append("<form action=\"ticket\" method=\"POST\">\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"computer\">").append("computer<br/>\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"shoes\">").append("shoes<br/>\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"socks\">").append("socks<br/>\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"trousers\">").append("trousers<br/>\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"keyboard\">").append("keyboard<br/>\n")
                .append("<input type=\"checkbox\" name=\"goods\" value=\"mouse\">").append("mouse<br/>\n")
                .append("<input type=\"submit\" value=\"Submit\">");
        writeFooter(response);
    }*/

    private void writeHeader(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("   <html>\n")
                .append("       <head>\n");
    }

    private void writeBody(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("       </head>\n")
                .append("       <body>\n");
    }

    private void writeFooter(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("        </body>\n")
                .append("   </html>\n");
    }
}
