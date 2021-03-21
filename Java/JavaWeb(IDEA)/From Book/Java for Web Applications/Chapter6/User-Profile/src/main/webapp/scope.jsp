<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/16
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<%--证明四个作用域的范围--%>
<%
    pageContext.setAttribute("a", "page");
    request.setAttribute("a", "request");
    session.setAttribute("a", "session");
    application.setAttribute("a", "application");

    request.setAttribute("b", "request");
    session.setAttribute("b", "session");
    application.setAttribute("b", "application");

    session.setAttribute("c", "session");
    application.setAttribute("c", "application");

    application.setAttribute("d", "application");
%>
<html>
<head>
    <title>Scope Demonstration</title>
</head>
<body>
    a = ${a} <br/>
    b = ${b} <br/>
    c = ${c} <br/>
    d = ${d} <br/>
</body>
</html>
