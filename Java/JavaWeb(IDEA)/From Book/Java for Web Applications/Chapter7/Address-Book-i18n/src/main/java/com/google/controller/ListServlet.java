package com.google.controller;

import com.google.model.Contact;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;
import java.time.Instant;
import java.time.Month;
import java.time.MonthDay;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * List servlet. 照着写来熟悉一下 <fmt> tags.
 *
 * @author wrox, Liao
 * @date 2021-3-26
 */
@WebServlet(
        name = "listServlet",
        urlPatterns = {"/list"}
)
public class ListServlet extends HttpServlet {
    private static final SortedSet<Contact> contactTreeSet = new TreeSet<>();

    static {
        contactTreeSet.add(new Contact("Jacky", "Cheung", "95533", "shanghai", MonthDay.of(Month.AUGUST, 21), Instant.parse("2013-02-01T21:22:23Z")));
        contactTreeSet.add(new Contact("Jay", "Chou", "95536", "taiwan", MonthDay.of(Month.JUNE, 3), Instant.parse("2012-10-15T15:31:17Z")));
        contactTreeSet.add(new Contact("Leehom", "Wang", "95535", "America", MonthDay.of(Month.SEPTEMBER, 30), Instant.parse("2012-10-15T19:45:22Z")));
        contactTreeSet.add(new Contact("Eason", "Chen", "95537", "Guangdong", null, Instant.parse("2013-04-05T01:45:01Z")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String language = request.getParameter("language");
        if ("french".equalsIgnoreCase(language)) {
            Config.set(request, Config.FMT_LOCALE, Locale.FRANCE);
        }

        if (request.getParameter("empty") != null) {
            request.setAttribute("contactTreeSet", new TreeSet<Contact>());
        } else {
            request.setAttribute("contactTreeSet", contactTreeSet);
        }

        request.getRequestDispatcher("/WEB-INF/jsp/view/list.jsp").forward(request, response);
    }
}
