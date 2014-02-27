<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <title></title>
</head>
<body>
<a href="<%=request.getContextPath()%>/payment/add">Add</a>
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
        <th>Amount</th>
        <th>Effective Date</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${payments}" var="payment">
        <tr>
            <td>${payment.name}</td>
            <td>${payment.description}</td>

        </tr>
    </c:forEach>
</table>
</body>
</html>
