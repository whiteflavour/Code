<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/2/28
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%!
    private static final String DEFAULT_USER = "Guest";
%>
<%
    String userName = request.getParameter("user");
    if (userName == null) {
        userName = DEFAULT_USER;
    }
%>
<%= "Hello " + userName + "! <br/>"%>
<html>
<head>
    <title>Hello</title>
</head>
<body>
    <form action="greeting.jsp" method="post">
        Enter your name: <input type="text" name="user"> <br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
