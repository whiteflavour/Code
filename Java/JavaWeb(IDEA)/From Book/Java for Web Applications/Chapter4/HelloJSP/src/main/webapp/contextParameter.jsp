<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/1
  Time: 11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>contextParameter</title>
</head>
<body>
    settingOne is <%= application.getInitParameter("settingOne")%>, &nbsp; <br/>
    settingTwo is <%= application.getInitParameter("settingTwo")%>
</body>
</html>
