<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Students</title>
</head>
<body>
    <%--@elvariable id="students" type="java.util.List"--%>
    ${students}
    <form method="post" action="<c:url value='/search.do'/>">
        <h2>Search student by id</h2> <br/>
        <label>
            <%--@elvariable id="id" type="java.lang.Integer"--%>
            Enter id: <input type="text" name="id" value="${id}"/> <br/>
        </label>
        <label>
            <input type="submit" value="Search"/>
        </label>
    </form>
</body>
</html>