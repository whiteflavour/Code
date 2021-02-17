<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/10
  Time: 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Videos</title>
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

<%-- YouTube 上的视频，点击分享，然后选择 嵌入 ，复制那段代码过来，即可浏览器内播放。 --%>
<iframe width="560" height="315" src="https://www.youtube.com/embed/WXmTxgDg52o" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>

<form action="Logout">
    <input type="submit" value="logout">
</form>

</body>
</html>
