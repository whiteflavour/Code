<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/1/27
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
    <%--等价于下面这句--%>
    <%--<%
        String name = request.getAttribute("label").toString();
        out.print(name);
    %>--%>

    <%--${stus} <br/>
    <c:out value="${stus}"></c:out>--%>


    <%--使用 forEach - core tag--%>
    <%--<c:forEach items="${stus}" var="stu">
        ${stu.name} <br/>
    </c:forEach>--%>
    <%--使用 SQL tag--%>
    <sql:setDataSource var="db" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost:3306/jdbc_start?useUnicode=true&characterEncoding=UTF-8" user="root" password="134679"></sql:setDataSource>
    <sql:update var="ar" dataSource="${db}">INSERT INTO info(`name`,age) VALUES('操',18);</sql:update>
    <sql:query var="rs" dataSource="${db}">SELECT * FROM info;</sql:query>

<%--    ${rs.rows}--%>

    <c:forEach items="${rs.rows}" var="student" >
        <c:out value="${student.id}"></c:out> &nbsp;
        <c:out value="${student.name}"></c:out> &nbsp;
        <c:out value="${student.age}"></c:out> <br/>
    </c:forEach>
</body>
</html>
