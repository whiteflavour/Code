<%@ page import="com.google.model.Goods" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/6
  Time: 10:00
  To change this template use File | Settings | File Templates.
--%>

<%-- 查看已经购买的物品的详情。 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Just do it</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("objectId").trim());
        @SuppressWarnings("unchecked")
        ArrayList<Goods> goodsArrayList = (ArrayList<Goods>)session.getAttribute("goodsArrayList"); %>
        <h2>You've bought: </h2> <ul>
    <%
        for (Goods object : goodsArrayList) {
            if (id == object.getId()) {
    %>
        <li><%=object.getName()%> ; Price: <%= object.getPrice()%> ￥</li>
    <%
            }
        }%> </ul> <br/>
    <h3>See you next time!</h3>
</body>
</html>
