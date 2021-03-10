<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.google.model.PageVisit" %>
<%@ page import="java.util.Vector" %><%--
  Created by IntelliJ IDEA.
  User: fuck
  Date: 2021/3/8
  Time: 8:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- 显示出什么时候进入页面和停留的时间 --%>
<html>
<head>
    <title>Session activity tracker</title>
</head>
<body>
    <%!
        private String toString(long timeInterval) {
            if (timeInterval < 1000) {
                return "No more than 1 second";
            }
            if (timeInterval < 60_000) {
                return (timeInterval / 1000) + " seconds";
            }
            return "about" + (timeInterval / 60_000) + " minutes";
        }
    %>
    <% SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, yyyy-MM-dd HH:mm:ss"); %>
    <h2>Session Properties</h2>
    <b><i>Session ID</i></b>: <%= session.getId() %> <br/>
    <b><i>Session is New</i></b>: <%= session.isNew() %> <br/>
    <b><i>Session created time</i></b>: <%= simpleDateFormat.format(new Date(session.getCreationTime())) %>

    <h2>Page Activity This Session</h2>
    <%
        @SuppressWarnings("unchecked")
        Vector<PageVisit> visits = (Vector<PageVisit>)session.getAttribute("activity");

        for (PageVisit visit :
                visits) {
            out.print(visit.getRequest());

            if (visit.getIpAddress() != null) {
                out.print(" from IP " + visit.getIpAddress().getHostAddress());
                out.print(" (" + simpleDateFormat.format(new Date(visit.getEnterTime())) + ") ");
            }

            if (visit.getLeftTime() != null) {
                out.print(", stayed for: " + toString(visit.getLeftTime() - visit.getEnterTime()) + "<br/> <br/>");
            }
        }
    %>
</body>
</html>
