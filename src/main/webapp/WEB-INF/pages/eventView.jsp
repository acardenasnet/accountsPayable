<%--
  Created by IntelliJ IDEA.
  User: acardenas
  Date: 1/28/14
  Time: 12:49 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="listValue" items="${list}">
        <c:out value="${listValue}" />
    </c:forEach>
</body>
</html>
