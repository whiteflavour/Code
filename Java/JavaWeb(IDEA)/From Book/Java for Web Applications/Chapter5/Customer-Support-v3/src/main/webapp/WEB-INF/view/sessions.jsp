<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/14
  Time: 17:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%-- Session （用户）停留的时间 --%>
<html>
<head>
    <title>Sessions</title>
</head>
<body>
    <%!
       private String toString(long timeIntervals) {
           if (timeIntervals < 1_000) {
               return "less than one second";
           }
           if (timeIntervals <= 60_000) {
               return "about " + (timeIntervals / 1_000) + " seconds";
           }
           return "about " + (timeIntervals / 60_000) + " minutes";
       }
    %>

    <h2>There are <%=request.getAttribute("numberOfSessions")%> sessions: </h2>
    <%
        @SuppressWarnings("unchecked")
        List<HttpSession> sessionList = (List<HttpSession>)request.getAttribute("sessionList");
        for (HttpSession aSession : sessionList) {
            long timeMillis = System.currentTimeMillis();
            if (aSession.getId().equals(session.getId())) {
                out.print("<i>User:</i> " + aSession.getAttribute("username") + ", <i>Session ID:</i> " + aSession.getId() + ", has stayed there for " + toString(aSession.getLastAccessedTime() - timeMillis));
            }
        }
    %>
</body>
</html>
