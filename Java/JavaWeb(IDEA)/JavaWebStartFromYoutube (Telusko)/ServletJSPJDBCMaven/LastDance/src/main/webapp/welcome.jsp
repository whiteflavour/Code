<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/9
  Time: 8:43
  To change this template use File | Settings | File Templates.
--%>

<%--
    Fixed EL could not work problem
    by adding isELIgnored="false" statement in Directive <%@ page %>.
    Liao, 2021-2-17
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Hello</title>
</head>
<body>

<%
    // 清除浏览器缓存
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1
    response.setHeader("Expires", "0"); // Proxy

    // 判断是否输入，若没输入，则继续在登录页面。
    if (session.getAttribute("student") == null) {
        response.sendRedirect("login.jsp");
    }
%>
<%-- EL, 可以指定范围，若不指定，则从最大范围开始，依次寻找。 --%>
Welcome, ${sessionScope.student}, <a href="video.jsp">your videos here ...</a> <br/>

<form action="Logout">
    <input type="submit" value="logout">
</form>

</body>
</html>
