<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/7
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videos</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
    <iframe width="560" height="315" src="https://www.youtube.com/embed/cYc3FjhMMzI" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

    <form action="Logout">
        <input type="submit" value="logout">
    </form>
</body>
</html>
