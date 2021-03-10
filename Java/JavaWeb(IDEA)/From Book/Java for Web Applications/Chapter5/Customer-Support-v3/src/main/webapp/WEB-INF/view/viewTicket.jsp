<%@ page import="java.util.Map" %>
<%@ page import="com.google.model.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/10
  Time: 7:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your ticket</title>
</head>
<body>
    <%
        Integer id = Integer.parseInt(request.getAttribute("ticketId").toString());
        if (id < 1) {
            response.sendRedirect("");
        }
        @SuppressWarnings("unchecked")
        Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>)request.getAttribute("ticketDatabase");

    %>
</body>
</html>
