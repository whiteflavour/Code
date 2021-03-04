<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/1
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Your liked fruits</title>
</head>
<body>
    Your liked fruits: <br/>
    <%
        String[] fruits = request.getParameterValues("fruits");
        if (fruits == null) {
    %>&nbsp;Noting ...<%
    } else {
    %>
        <ul><%
        for (String fruit : fruits) {
    %> <li><%=fruit%></li> <%
        } %>
        </ul> <%
        }
    %>
</body>
</html>
