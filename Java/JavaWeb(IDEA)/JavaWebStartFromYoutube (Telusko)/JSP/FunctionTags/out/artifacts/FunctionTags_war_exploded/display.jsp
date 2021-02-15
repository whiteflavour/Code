<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%--
  Created by IntelliJ IDEA.
  User: Fuck
  Date: 2021/2/1
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>function</title>
</head>
<body>
    <c:set var="str" value="Liao Xianyu loves Xiong Siying forever"></c:set>

    Output: ${str} <br/>
    Length: ${fn:length(str)} <br/>

    <c:if test="${fn:contains(str, 'Xiong Siying')}">
        Xiong Siying is there. <br/>
    </c:if>

    <c:if test="${fn:endsWith(str, 'forever')}">
        Good Mind! <br/>
    </c:if>

    ${fn:toUpperCase(str)} <br/>
    ${fn:toLowerCase(str)} <br/>

    ${fn:trim(str)}
</body>
</html>
