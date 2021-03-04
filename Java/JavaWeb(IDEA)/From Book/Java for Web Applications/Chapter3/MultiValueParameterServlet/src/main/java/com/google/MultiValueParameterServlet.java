package com.google;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Tell me your favorite fruits.
 *
 * @author Liao, wrox
 * @date 2021-2-23
 */
@WebServlet(name = "multiValueParameterServlet",
        urlPatterns = {"/checkboxes"}
)
public class MultiValueParameterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("   <head>\n")
                .append("       <meta charset=utf8>\n")
                .append("       <title>MultiValueParameter</title>\n")
                .append("   </head>\n")
                .append("   <body>\n")
                .append("       What are your favorite fruits? <br/>\n")
                .append("       <form action=\"checkboxes\" method=\"POST\">\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Apple\">").append("Apple<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Banana\">").append("Banana<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Watermelon\">").append("Watermelon<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Orange\">").append("Orange<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Peach\">").append("Peach<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Pear\">").append("Pear<br/>\n")
                .append("           <input type=\"checkbox\" name=\"fruits\" value=\"Grape\">").append("Grape<br/>\n")
                .append("           <input type=\"submit\" value=\"Submit\"\n")
                .append("   </body>\n")
                .append("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] fruits = request.getParameterValues("fruits");

        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.append("<!DOCTYPE html>\n")
                .append("<html>\n")
                .append("<head>\n")
                .append("   <meta charset=utf8>\n")
                .append("   <title>Output</title>\n")
                .append("</head>\n")
                .append("<body>\n")
                .append("Your favorite fruits: <br/>\n");
        if (fruits == null) {
            out.append("Nothing ... <br/>");
        } else {
            out.append("<ul>\n");
            for (String value :
                    fruits) {
                out.append("<li>").append(value).append("</li>\n");
            }
            out.append("</ul>\n");
        }
    }
}
