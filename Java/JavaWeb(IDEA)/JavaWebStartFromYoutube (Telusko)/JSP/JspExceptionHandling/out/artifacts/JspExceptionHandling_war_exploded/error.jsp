<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/22
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>

<%--The Error Page--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<html>
<head>
    <title>Error</title>
</head>
<body bgcolor="red">
    Error: <%= exception.getMessage() %>
</body>
</html>
