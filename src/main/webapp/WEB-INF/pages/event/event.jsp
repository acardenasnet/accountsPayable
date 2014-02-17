<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title></title>
</head>
<body>
<a href="<%=request.getContextPath()%>/event/add">Add</a>
<table>
    <tr>
        <th>name</th>
        <th>Account Payable</th>
        <th>edit</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${events}" var="event">
        <tr>
            <td>${event.name}</td>
            <td><a href="<%=request.getContextPath()%>/accountPayable/${event.id}">accounts payable</a></td>
            <td><a href="<%=request.getContextPath()%>/event/edit/${event.id}">edit</a></td>
            <td><a href="<%=request.getContextPath()%>/event/delete/${event.id}">delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
