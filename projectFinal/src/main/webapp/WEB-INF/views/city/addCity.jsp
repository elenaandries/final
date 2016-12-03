<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>

<t:layout>
    <div class="col-lg-12">
        <div class="ibox float-e-margins">
            <div class="ibox-content">
                <div>Add</div>
                <br />

                <form:form method="POST" action="${baseURI}city/addCity" modelAttribute="post" class="form-horizontal">
                </form:form>
            </div>
        </div>
    </div>
</t:layout>