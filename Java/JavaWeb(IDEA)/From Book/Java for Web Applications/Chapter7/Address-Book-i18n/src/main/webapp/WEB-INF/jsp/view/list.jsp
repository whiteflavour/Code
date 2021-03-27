<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/20
  Time: 12:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ include file="/WEB-INF/jsp/base.jspf"%>

<%--Display contacts' information. --%>

<%--@elvariable id="contactTreeSet" type="java.util.Set<com.google.model.Contact>"--%>

<html>
<head>
    <%--这里必须要设置 Bundle，右侧的资源文件夹有说明，那是 IDEA 自动创建的。--%>
    <%--若不设置，会找不到资源包。--%>
    <fmt:setBundle basename="AddressBook-messages" var="addressBook"/>

    <%--注意 bundle 属性要使用 ${} --%>
    <title><fmt:message key="title.browser" bundle="${addressBook}"/></title>
</head>
<body>
    <h2><fmt:message key="title.page" bundle="${addressBook}"/>: </h2> <br/>
    <c:choose>
        <c:when test="${fn:length(contactTreeSet) == 0}">
            <i><fmt:message key="message.noContacts" bundle="${addressBook}"/></i>
        </c:when>
        <c:otherwise>
            <c:forEach items="${contactTreeSet}" var="contact">
                <b>
                    <c:out value="${contact.lastName}, ${contact.firstName}"/>
                </b> <br/>
                <c:out value="${contact.phoneNumber}"/> <br/>
                <c:if test="${contact.birthday != null}">
                    <fmt:message key="label.birthday" bundle="${addressBook}"/>: ${contact.birthday.month.getDisplayName('FULL', pageContext.response.locale)}&nbsp;${contact.birthday.dayOfMonth} <br/>
                </c:if>
                <fmt:message key="label.creationDate" bundle="${addressBook}"/>: <fmt:formatDate value="${contact.oldDateCreated}" type="both" dateStyle="long" timeStyle="long"/>
                <br/><br/>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</body>
</html>
