<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
  ~ ---------------------------------------------------------------------------
  ~    COPYRIGHT Alejandro Cardenas, acardenas.net, Saltillo,Coah, MX 2014.
  ~    All rights reserved.
  ~
  ~    The Copyright to the computer program(s) herein is the property of
  ~    Alejandro Raul Cardenas
  ~    The program(s) may be used and/or copied only with the written
  ~    permission from Alejandro Cardenas, or in
  ~    accordance with the terms and conditions stipulated in the
  ~    agreement/contract under which the program(s) have been supplied.
  ~    ---------------------------------------------------------------------------
  --%>

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
