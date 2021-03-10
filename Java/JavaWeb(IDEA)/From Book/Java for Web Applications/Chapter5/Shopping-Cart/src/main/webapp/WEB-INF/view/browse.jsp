<%@ page import="com.google.dao.ShoppingDao" %>
<%@ page import="com.google.model.Goods" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/5
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>

<%-- 列出物品，并可以选择需要购买的东西。 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Happy Shopping</title>
</head>
<body>
    <%
        ShoppingDao shoppingDao = new ShoppingDao();
        ArrayList<Goods> goodsArrayList = shoppingDao.getGoods();
        session.setAttribute("goodsArrayList", goodsArrayList); %> <h2>Put them into your cart! </h2> <%
        for (Goods object :
                goodsArrayList) { %>
        <form action="shop" method="post">

            <input type="checkbox" name="goods" value="<%=object.getName()%>"> <%=object.getName()%> : &nbsp; <%=object.getPrice()%>￥<br/>
        <%}%>
            <input type="submit" value="addToCart">
        </form>
</body>
</html>
