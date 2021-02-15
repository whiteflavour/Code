<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/20
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Number</title>
</head>
<body>
    <%= 9 + 7 + "<br/>"%>
    <% pageContext.setAttribute("name", "Jack", PageContext.SESSION_SCOPE); %>
    <%= pageContext.getAttribute("name") + "<br/>"%>
</body>
</html>
