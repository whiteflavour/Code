<%@ page import="com.google.model.Goods" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/5
  Time: 15:26
  To change this template use File | Settings | File Templates.
--%>

<%-- 列出购物车里面的东西，并且可以点击链接来进行购买。只能单个查看，多个购买功能暂未实现。 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Own it</title>
</head>
<body>
    <%
        String[] goods = (String[])session.getAttribute("goods");
        if (goods == null) {
            out.print("You bought nothing ... ");
        } else { %> <h2>Buy me: </h2>
    <%
            @SuppressWarnings("unchecked")
            ArrayList<Goods> goodsArrayList = (ArrayList<Goods>) session.getAttribute("goodsArrayList");
            int id = 0;
            for (String objectName :
                    goods) { %>
                <a href="shop?action=detail&objectId=<%for (Goods object: goodsArrayList) {
                    if (objectName.equals(object.getName())) {
                        id = object.getId();
                    }
                }%> <%= id%>"><%= objectName %></a> <br/>
        <%}
        }%>
</body>
</html>
