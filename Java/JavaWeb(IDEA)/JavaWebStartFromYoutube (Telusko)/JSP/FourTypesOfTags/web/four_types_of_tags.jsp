<%-- Directive --%>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/18
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Four Tags</title>
</head>
<body>
    <%-- Declaration --%>
    <%!
        public String date() {
            Date date = new Date();
            return date.toString();
        }
    %>

    <%! int value = 1; %>

    <%
        out.println("Go fuck yourself<br/>");
        out.println("滚蛋<br/>");
        out.println("没有人能够突破我的枪围<br/>");
    %>
    <%
        out.println("去你妈的<br/>");
    %>
    <% out.println("卧槽<br/>"); %>

    <%-- Scriptlet --%>
    <%
        out.println("Now: " + date() + "<br/>");
        out.println("我日你哥<br/>");
    %>

    <%-- Expression --%>
    <%=
        "Now: " + date() + "<br/>"
    %>
    There is a number : <%= value + "<br/>" %>
    There is a number : <% out.println(value + "<br/>"); %>
    <%= value %>
</body>
</html>
