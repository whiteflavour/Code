package com.google.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

/**
 * An easy shop cart system, with the functions of viewing cart, looking through goods and showing the detail of the goods. 
 *
 * @author Liao
 * @date 2021-3-6
 */
@WebServlet(
        name = "storeServlet",
        urlPatterns = {"/shop"}
)
public class StoreServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "browse";
        }
        switch (action) {
            case "detail":
                detail(request, response);
                break;
            case "viewCart":
                viewCart(request, response);
                break;
            case "browse":
            default:
                browse(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        viewCart(request, response);
    }

    /**
     * show the detail of the goods.
     */
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/detail.jsp").forward(request, response);
    }

    /**
     * view your shopping cart, and list the goods you want to buy. 
     */
    public void viewCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] goods = request.getParameterValues("goods");
        HttpSession session = request.getSession();
        session.setAttribute("goods", goods);
        request.getRequestDispatcher("/WEB-INF/view/viewCart.jsp").forward(request, response);
    }

    /**
     * look through all goods in the market. 
     */
    public void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/view/browse.jsp").forward(request, response);
    }
}
