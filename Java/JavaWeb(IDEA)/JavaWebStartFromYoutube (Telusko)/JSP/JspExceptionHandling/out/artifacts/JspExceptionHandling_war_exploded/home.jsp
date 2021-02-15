<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/22
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <%
        // try/catch to handle exception
        /*try {
            int k = 9 / 0;
        } catch (Exception e) {
            out.println("Error: " + e.getMessage());
        }*/

        // Best method: handling in another page.
        // We'll handle it in error.jsp
        int k = 5 / 0;
    %>
</body>
</html>
