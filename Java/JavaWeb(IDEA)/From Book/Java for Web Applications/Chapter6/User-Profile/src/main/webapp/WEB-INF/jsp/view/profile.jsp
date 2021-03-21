<%--@elvariable id="user" type="com.google.model.User"--%>
<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/15
  Time: 14:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>

<%--展示用户信息和权限--%>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    ID: ${user.id} <br/>
    Username: ${user.username} (${user.username.length()} characters) <br/>
    Full Name: ${fn:escapeXml(user.lastName) += ', ' += fn:escapeXml(user.firstName)} <br/> <br/>

    <b>Permissions (${fn:length(user.permissions)})</b> <br/>
    User: ${user.permissions["user"]} <br/>
    Moderator: ${user.permissions["moderator"]} <br/>
    Administrator: ${user.permissions["admin"]}
</body>
</html>
