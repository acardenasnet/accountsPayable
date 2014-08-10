<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table>
    <tr>
        <th>Name</th>
        <th>Total</th>
        <th>Payment</th>
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

<div id=edit>
    <c:set var="path" value="<%=request.getContextPath()%>"></c:set>
    <form:form action="${path}/accountPayable/save" commandName="accountPayable">
        <form:hidden path="id"/>
        <form:hidden path="event.id"/>
        <table>
            <tr>
                <td><form:label path="name">name</form:label></td>
                <td><form:input path="name"/></td>
                <td><form:label path="Total">Total</form:label></td>
                <td><form:input path="total"/></td>
            </tr>
        </table>
        <input class="button" type="submit" class="add_button" value="save">
    </form:form>
</div>
