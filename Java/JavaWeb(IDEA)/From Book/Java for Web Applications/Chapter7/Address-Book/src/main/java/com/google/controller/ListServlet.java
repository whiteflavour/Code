package com.google.controller;

import com.google.model.Contact;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Calendar;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * A list Servlet to create contactTreeSet.
 *
 * @author Liao, wrox
 * @date 2021-3-26
 */
@WebServlet(
        name = "listServlet",
        urlPatterns = {"/list"}
)
public class ListServlet extends HttpServlet {
    static SortedSet<Contact> contactTreeSet = new TreeSet<>();
    static {
        contactTreeSet.add(new Contact("Jacky", "Cheung", "95533", "shanghai", "8.21", Calendar.getInstance().getTime()));
        contactTreeSet.add(new Contact("Jay", "Chou", "95536", "taiwan", "1.18", Calendar.getInstance().getTime()));
        contactTreeSet.add(new Contact("Leehom", "Wang", "95535", "America", "6.22", Calendar.getInstance().getTime()));
        contactTreeSet.add(new Contact("Eason", "Chen", "95537", "Guangdong", "12.12", Calendar.getInstance().getTime()));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("contactTreeSet", contactTreeSet);
        request.getRequestDispatcher("/WEB-INF/jsp/view/display.jsp").forward(request, response);
    }
}
