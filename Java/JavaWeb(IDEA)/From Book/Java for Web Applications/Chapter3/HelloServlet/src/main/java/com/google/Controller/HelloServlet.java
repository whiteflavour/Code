package com.google.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * To understand doGet and doPost more deeply.
 *
 * @author Liao, wrox
 * @date 2021-2-23
 */
@WebServlet(
        name = "helloServlet",
        urlPatterns = {"/greeting", "/salutation", "/wazzup"},
        loadOnStartup = 1
)
public class HelloServlet extends HttpServlet {
    private static final String DEFAULT_USER = "Guest";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("user");
        if (user == null) {
            user = HelloServlet.DEFAULT_USER;
        }
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("   <head>\n")
                .append("       <meta charset=utf8>\n")
                .append("       <title>Hello User Application</title>\n")
                .append("   </head>\n")
                .append("   <body>\n")
                .append("       Hello, ").append(user).append("! <br/><br/>\n")
                .append("       <form action=\"greeting\" method=\"POST\">\n")
                .append("           Enter your name: <br/>\n")
                .append("           <input type=\"text\" name=\"user\"><br/>\n")
                .append("           <input type=\"submit\" value=\"Submit\">\n")
                .append("       </form>\n")
                .append("   </body>\n")
                .append("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started.");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped.");
    }
}
