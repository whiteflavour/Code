<%@ page import="com.google.model.Ticket" %>
<%@ page import="com.google.model.Attachment" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/4
  Time: 9:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" session="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String ticketId = (String)request.getAttribute("ticketId");
    Ticket ticket = (Ticket)request.getAttribute("ticket");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<h2>Ticket #<%= ticketId %>: <%= ticket.getSubject() %></h2>
<i>Customer Name - <%= ticket.getCustomerName() %></i><br /><br />
<%= ticket.getBody() %><br /><br />
<%
    if(ticket.getNumberOfAttachments() > 0)
    {
%>Attachments: <%
    int i = 0;
    for(Attachment a : ticket.getAttachments())
    {
        if(i++ > 0)
            out.print(", ");
%><a href="<c:url value="/tickets">
                        <c:param name="action" value="download" />
                        <c:param name="ticketId" value="<%= ticketId %>" />
                        <c:param name="attachment" value="<%= a.getName() %>" />
                    </c:url>"><%= a.getName() %></a><%
    }
%><br /><br /><%
    }
%>
<a href="<c:url value="/tickets" />">Return to list tickets</a>
</body>
</html>
