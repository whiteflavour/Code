<%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/4
  Time: 9:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="false" import="java.util.Map" %>
<%@ page import="com.google.model.Ticket" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    @SuppressWarnings("unchecked")
    Map<Integer, Ticket> ticketDatabase =
            (Map<Integer, Ticket>)request.getAttribute("ticketDatabase");
%>
<!DOCTYPE html>
<html>
<head>
    <title>Customer Support</title>
</head>
<body>
<h2>Tickets</h2>
<a href="<c:url value="/tickets">
            <c:param name="action" value="create" />
        </c:url>">Create Ticket</a><br /><br />
<%
    if(ticketDatabase.size() == 0)
    {
%><i>There are no tickets in the system.</i><%
}
else
{
    for(int id : ticketDatabase.keySet())
    {
        String idString = Integer.toString(id);
        Ticket ticket = ticketDatabase.get(id);
%>Ticket #<%= idString %>: <a href="<c:url value="/tickets">
                        <c:param name="action" value="view" />
                        <c:param name="ticketId" value="<%= idString %>" />
                    </c:url>"><%= ticket.getSubject() %></a> (customer:
<%= ticket.getCustomerName() %>)<br /><%
        }
    }
%>
</body>
</html>
