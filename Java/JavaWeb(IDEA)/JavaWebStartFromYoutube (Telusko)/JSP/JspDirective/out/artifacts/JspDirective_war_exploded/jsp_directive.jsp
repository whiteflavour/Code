<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/20
  Time: 13:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page info="JSP Directive" %>
<%@ page pageEncoding="UTF-8" %>
<%@ include file="a_number.jsp" %>
<html>
<head>
    <title>Directive</title>
</head>
<body>
    <%
        out.print(getServletInfo() + "<br/>");

        out.print(pageContext.getAttribute("name", PageContext.SESSION_SCOPE) + "<br/>");
    %>
    <%= pageContext.getAttribute("name") + "<br/>"%>
</body>
</html>
