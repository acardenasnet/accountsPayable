<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>CRUD Spring MVC</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<form:form action="${path}/accountPayable/save" commandName="accountPayable">
    <form:hidden path="id" />
    <table>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name" /></td>
            <td><form:label path="Total">name</form:label></td>
            <td><form:input path="total" /></td>
        </tr>
    </table>
    <input class="button" type="submit" class="add_button" value="save">
</form:form>
</body>
</html>