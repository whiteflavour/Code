<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.Map" %>
<%@ page import="com.google.model.Ticket" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/9
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- 列出拥有的 tickets --%>
<html>
<head>
    <title>Your tickets</title>
</head>
<body>
    <h2>
        No tickets?
        <a href="<c:url value="/tickets?action=create"/>"> Create it here</a>
    </h2>
    <%
        @SuppressWarnings("unchecked")
        Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>)request.getAttribute("ticketDatabase");
        if (ticketDatabase.isEmpty()) {
            out.print("Nothing ...");
        } else {
            for (int id : ticketDatabase.keySet()) {
                String idString = Integer.toString(id);%>

                <a href="<c:url value="/tickets">
                    <c:param name="action" value="view"/>
                    <c:param name="ticketId" value="<%=idString%>"/>
                         </c:url>">
                <%= ticketDatabase.get(id).getSubject() %></a> <br/>
            <%}
        }%>

</body>
</html>
