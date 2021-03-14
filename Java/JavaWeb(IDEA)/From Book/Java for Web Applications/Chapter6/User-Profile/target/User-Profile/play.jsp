<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/13
  Time: 15:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %>
<html>
<head>
    <title>Demos</title>
</head>
<body>
    ${map = {1 : "Fuck", 2 : "qnmd"} }
    ${empty map}
    ${map["1"]}
</body>
</html>
