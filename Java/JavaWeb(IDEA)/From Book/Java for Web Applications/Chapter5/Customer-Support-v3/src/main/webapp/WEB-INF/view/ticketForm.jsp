<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/9
  Time: 9:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create your ticket</title>
</head>
<body>
    <h1>Create your ticket: </h1> <br/>
    <form action="tickets" method="post" enctype="multipart/form-data">
        <input type="hidden" name="action" value="create"/>
        <h2>Your name: </h2> <br/>
        <input type="text" name="customerName"/>
        <h2>Subject: </h2> <br/>
        <input type="text" name="subject"/>
        <h2>Body: </h2> <br/>
        <textarea rows="5" cols="30" name="body"></textarea>
        <input type="file" name="file1"/>
        <input type="submit" value="Submit"/>
    </form>
</body>
</html>
