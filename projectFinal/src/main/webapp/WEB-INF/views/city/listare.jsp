<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<t:layout>
    <table class="responsive table">
        <tr>
            <th>Name</th>
            <th>Country</th>
        </tr>

        <c:forEach var="city" items="${cities}">
            <tr>
                <td><c:out value="${city.getName()}"/></td>
                <td><c:out value="${city.getCountry().getName()}"/></td>
                <td>
                    <a href="${baseURI}city/${id}/update">Edit</a>
                </td>
                <td>
                    <a href="${baseURI}city/${id}}/delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
</table>
</t:layout>
