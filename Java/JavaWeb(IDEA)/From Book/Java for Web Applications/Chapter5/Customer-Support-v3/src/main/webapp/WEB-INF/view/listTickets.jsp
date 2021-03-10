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
<html>
<head>
    <title>Your tickets</title>
</head>
<body>
    <a href="<c:url value="/tickets?action=create"/>">Create a ticket here</a>
    <%
        @SuppressWarnings("unchecked")
        Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>)request.getAttribute("ticketDatabase");
        if (ticketDatabase.isEmpty()) {
            out.print("Nothing ...");
        } else {
            for (Integer id : ticketDatabase.keySet()) { %>
    <a href="<c:url value="/tickets?action=view&ticketId=<%= id %>"/>">ticketDatabase.get(id).getSubject();</a>
            <%}
        }%>

</body>
</html>
