<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/9
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 显示创建票据的格式 --%>
<html>
<head>
    <title>Create your ticket</title>
</head>
<body>
    <h1>Create your ticket: </h1>
    <form action="tickets" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create"/>
        Your name: <br/>
        <input type="text" name="customerName"/> <br/>
        Subject: <br/>
        <input type="text" name="subject"/> <br/>
        Body: <br/>
        <textarea rows="5" cols="30" name="body"></textarea>
        <input type="file" name="file1"/> <br/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
