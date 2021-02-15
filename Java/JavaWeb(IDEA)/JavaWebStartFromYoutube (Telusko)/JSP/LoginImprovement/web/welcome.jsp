<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/7
  Time: 13:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.

    if (session.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
    }
%>
    Welcome ${username}, <a href="video.jsp">your videos here</a> <br/>
    <form action="Logout">
        <input type="submit" value="logout">
    </form>
</body>
</html>
