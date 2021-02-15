<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/16
  Time: 11:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
    <body bgcolor="cyan">
        <!-- Delimiter，在其中写 Java 代码 -->
        <%
            int number1 = Integer.parseInt(request.getParameter("num1"));
            int number2 = Integer.parseInt(request.getParameter("num2"));

            int sum = number1 + number2;

            out.println("The result is: " + sum);
        %>
    </body>
</html>
