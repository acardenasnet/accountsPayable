<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="<%=request.getContextPath()%>"></c:set>
<form:form action="${path}/accountPayable/save" commandName="accountPayable">
    <form:hidden path="id" />
	<form:hidden path="event.id"/>
    <table>
        <tr>
            <td><form:label path="name">name</form:label></td>
            <td><form:input path="name" /></td>
            <td><form:label path="Total">Total</form:label></td>
            <td><form:input path="total" /></td>
        </tr>
    </table>
    <input class="button" type="submit" class="add_button" value="save">
</form:form>
