<%@ page import="java.util.Map" %>
<%@ page import="com.google.model.Ticket" %>
<%@ page import="com.google.model.Attachment" %>
<%@ page import="java.util.Collection" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/10
  Time: 7:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 根据 ID 查看每一个票据的信息 --%>
<html>
<head>
    <title>Your ticket</title>
</head>
<body>
    <%
        int id = Integer.parseInt(request.getParameter("ticketId").trim());
        if (id < 1) {
            request.getRequestDispatcher("noTickets.jsp").forward(request, response);
        }
        @SuppressWarnings("unchecked")
        Map<Integer, Ticket> ticketDatabase = (Map<Integer, Ticket>)request.getAttribute("ticketDatabase");

        Ticket ticket = ticketDatabase.get(id);
    %>
        Your name: <%= ticket.getCustomerName() %> <br/>
        Subject: <%= ticket.getSubject() %> <br/>
        Body: <%= ticket.getBody() %> <br/>

    <br/>
    <i>Download attachments here: </i> <br/>
    <%
        Collection<Attachment> attachmentCollection = ticket.getAttachments();
        if (attachmentCollection.isEmpty()) {
            out.print("No attachments ... ");
        } else {
            for (Attachment attachment : attachmentCollection) {%>
                <a href="<c:url value="/tickets">
                            <c:param name="action" value="download" />
                            <c:param name="ticketId" value="<%=Integer.toString(id)%>" />
                            <c:param name="attachmentName" value="<%=attachment.getName()%>" />
                        </c:url>"><%= attachment.getName() %></a> <br/>
    <%}
        }%>

    <br/><br/>
    <b>Go to ticket list: </b>
    <a href="<c:url value="/tickets">
        <c:param name="action" value="list" />
</c:url>">here</a>
</body>
</html>
