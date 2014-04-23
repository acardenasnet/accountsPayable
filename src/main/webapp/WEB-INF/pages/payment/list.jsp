<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div id="add">
<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<form:form action="${path}/payment/save" commandName="payment">
    <form:hidden path="id" />
    <form:hidden path="accountPayable.id"/>
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
</div>