<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.google.model.Student"%>

<%
    ArrayList<String> arrayList = new ArrayList<>();
    arrayList.add("Tom");
    arrayList.add("Jerry");
    arrayList.add("Jack");
    arrayList.add("Rose");
    request.setAttribute("arrayList", arrayList);
    Student student = new Student();
    request.setAttribute("student", student);
%>
<%--@elvariable id="student" type="com.google.model.Student"--%>
<c:set target="${student}" value="qnmd" property="name"/>
${student.name}