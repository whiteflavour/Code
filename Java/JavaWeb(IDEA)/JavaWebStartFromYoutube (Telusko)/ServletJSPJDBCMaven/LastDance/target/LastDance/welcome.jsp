<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/9
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    response.setHeader("Expires", "0");

    if (session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
    }
%>

Welcome, ${student}, <a href="video.jsp">your videos here ...</a> <br/>

<form action="Logout">
    <input type="submit" value="logout">
</form>

</body>
</html>
