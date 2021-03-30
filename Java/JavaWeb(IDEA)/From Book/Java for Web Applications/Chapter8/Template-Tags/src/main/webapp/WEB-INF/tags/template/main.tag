<%@ tag body-content="scriptless" dynamic-attributes="dynamicAttributes" isELIgnored="false"%>
<%@ attribute name="htmlTitle" type="java.lang.String" rtexprvalue="true" required="true"%>
<%@ include file="/WEB-INF/jsp/base.jspf"%>

<!DOCTYPE html>
<html <c:forEach items="${dynamicAttributes}" var="a">
    <c:out value="${a.key} = '${fn:escapeXml(a.value)}'" escapeXml="false"/>
</c:forEach>>
    <head>
        <title><c:out value="${fn:trim(htmlTitle)}"/></title>
    </head>
    <body>
        <jsp:doBody/>
    </body>
</html>