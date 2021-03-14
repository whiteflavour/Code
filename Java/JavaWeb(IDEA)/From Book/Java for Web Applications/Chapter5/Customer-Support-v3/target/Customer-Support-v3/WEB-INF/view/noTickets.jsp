<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/10
  Time: 8:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>No tickets?</title>
</head>
<body>
    <h2>
        There are not tickets, create it
        <a href="<c:url value="/tickets?action=create"/>">here</a>
    </h2>
</body>
</html>
