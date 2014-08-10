<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title></title>
</head>
<body>
    <c:forEach var="listValue" items="${list}">
        <c:out value="${listValue}"  />
        <br/>
    </c:forEach>
</body>
</html>
