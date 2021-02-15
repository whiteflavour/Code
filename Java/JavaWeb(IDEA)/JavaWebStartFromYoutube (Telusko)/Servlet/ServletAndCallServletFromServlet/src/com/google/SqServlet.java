package com.google;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Use a Servlet to call another Servlet.
 * This is the called Servlet.
 */
@WebServlet("/sq")
public class SqServlet extends HttpServlet {
    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException {
        int k = 0;

        // use Cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie value :
                cookies) {
            if (value.getName().equals("k")) {
                k = Integer.parseInt(value.getValue());
            }
        }


        // 使用 RequestDispatcher
        //        int sq = (int)req.getAttribute("sq");


        // use Session
        /*HttpSession session = req.getSession();
        // remove Session
        session.removeAttribute("k");
        // so the "k" will not be got
        int k = (int) session.getAttribute("k");*/

        PrintWriter out = res.getWriter();

        res.setContentType("text/html");

        // 若没有前面那句话来指定返回客户端的内容类型，首标签必须放在其他输出的前面，否则会直接输出字符串，而不会以 HTML 的格式输出。★
        // 经自己尝试，在 HTML 中，是可以将文本放在任何地方的，但此处不支持。★
        out.println("The Result is " + (k * k));
        out.print("<html><body bgcolor='cyan'>");
        out.print("</html></body>");

        System.out.println("sq called");

        // 从 URL 中获取值 k
//        int k = Integer.parseInt(req.getParameter("k"));
    }
}