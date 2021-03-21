<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/16
  Time: 9:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="WEB-INF/jsp/base.jspf"%>

<%--使用一些隐式对象--%>
<%
    application.setAttribute("appAttribute", "foo");
    pageContext.setAttribute("pageAttribute", "bar");
    session.setAttribute("sessionAttribute", "sand");
    request.setAttribute("requestAttribute", "castle");
%>
<html>
<head>
    <title>Information</title>
</head>
<body>
    Remote Address: ${pageContext.request.remoteAddr} <br/>
    Request URL: ${pageContext.request.requestURL} <br/>
    Session ID: ${pageContext.request.session.id} <br/>
    Application Scope: ${applicationScope["appAttribute"]} <br/>
    Page Scope: ${pageScope["pageAttribute"]} <br/>
    Session Scope: ${sessionScope["sessionAttribute"]} <br/>
    Request Scope: ${requestScope["requestAttribute"]} <br/>
    User Parameter: ${param["user"]} <br/>
    Color Multi-Param: ${fn:join(paramValues["colors"], ',')} <br/>
    Accept Header: ${header["Accept"]} <br/>
    Session ID Cookie Value: ${cookie["JSESSIONID"].value}
</body>
</html>
