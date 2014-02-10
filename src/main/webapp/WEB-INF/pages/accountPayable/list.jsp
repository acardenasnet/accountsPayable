<%--
  Created by IntelliJ IDEA.
  User: acardenas
  Date: 2/6/14
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title></title>
</head>
<body>
<a href="<%=request.getContextPath()%>/accountPayable/add">Add</a>
<table>
    <tr>
        <th>Name</th>
        <th>Total</th>
        <th>Account Payable</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${accountsPayable}" var="accountPayable">
        <tr>
            <td>${accountPayable.name}</td>
            <td>${accountPayable.total}</td>
            <td><a href="<%=request.getContextPath()%>/payment/${accountPayable.id}">Payments</a></td>
            <td><a href="<%=request.getContextPath()%>/accountPayable/edit/${accountPayable.id}">edit</a></td>
            <td><a href="<%=request.getContextPath()%>/accountPayable/delete/${accountPayable.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
