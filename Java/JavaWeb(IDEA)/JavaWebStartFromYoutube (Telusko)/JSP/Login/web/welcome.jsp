<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/6
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
    <%
        if (session.getAttribute("username") == null) {
            response.sendRedirect("login.jsp");
        }
    %>
    Welcome ${username} <br/>

    <a href="video.jsp">Your videos here</a> &nbsp;
    <a href="aboutus.jsp">about us</a> <br/>

    <form action="Logout">
        <input type="submit" value="logout">
    </form>
</body>
</html>
