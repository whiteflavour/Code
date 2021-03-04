<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/1
  Time: 10:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Choose your liked fruits</title>
</head>
<body>
    Choose your liked fruits: <br/>
    <form action="checkboxesSubmit.jsp" method="post">
        <input type="checkbox" name="fruits" value="apple"> Apple <br/>
        <input type="checkbox" name="fruits" value="banana"> Banana <br/>
        <input type="checkbox" name="fruits" value="orange"> Orange <br/>
        <input type="checkbox" name="fruits" value="pear"> Pear <br/>
        <input type="checkbox" name="fruits" value="peach"> Peach <br/>
        <input type="checkbox" name="fruits" value="watermelon"> Watermelon <br/>
        <input type="checkbox" name="fruits" value="grapes"> Grapes <br/>
        <input type="submit" value="Submit">
    </form>
</body>
</html>
