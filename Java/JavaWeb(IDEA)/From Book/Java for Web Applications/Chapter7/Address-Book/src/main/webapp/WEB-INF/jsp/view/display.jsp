<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/20
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>

<%--Display the contacts' information. --%>

<%--@elvariable id="contactTreeSet" type="java.util.SortedSet<com.google.model.Contact>"--%>
<html>
<head>
    <title>Contact Info</title>
</head>
<body>
    <h1>Contacts: </h1> <br/>
    <c:choose>
        <c:when test="${fn:length(contactTreeSet) == 0}">
            No contacts ...
        </c:when>
        <c:otherwise>
            <c:forEach items="${contactTreeSet}" var="contact">
                <h2>${contact.firstName += " " += contact.lastName}</h2> <br/>
                <b>Phone Number : </b>${contact.phoneNumber} <br/>
                <b>Address : </b> ${contact.address} <br/>
                <c:if test="${contact.birthday != null}">
                    <b>Birthday: </b> ${contact.birthday} <br/>
                </c:if>
                <b>Created time : </b> ${contact.createdDate} <br/>
                <br/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
