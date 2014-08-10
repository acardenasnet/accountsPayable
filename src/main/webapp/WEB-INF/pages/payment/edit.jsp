<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <title>CRUD Spring MVC</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
</head>
<body>
<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<form:form action="${path}/payment/save/1" commandName="payment">
    <form:hidden path="id" />
    <table>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name" /></td>
            <td><form:label path="description">Description</form:label></td>
            <td><form:input path="description" /></td>
            <td><form:label path="amount">Amount</form:label></td>
            <td><form:input path="amount" /></td>
            <td><form:label path="effectiveDate">Effective Date</form:label></td>
            <td><form:input path="effectiveDate" /></td>
        </tr>
    </table>
    <input class="button" type="submit" class="add_button" value="save"/>
</form:form>
</body>
</html>