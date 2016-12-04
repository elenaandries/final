<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true"%>

<t:user_layout>
    <div class="container">
        <div class="col-md-4 col-md-offset-4">
        <c:if test="${not empty error}">
            <div class="error">${error}</div>
        </c:if>
        <c:if test="${not empty msg}">
            <div class="msg">${msg}</div>
        </c:if>

        <form class="form-signin" name='loginUserForm' action="<c:url value='/user/login' />" method='POST'>
            <h2 class="form-signin-heading">Login</h2>

            <label for="inputEmail" class="sr-only">Email address</label>
            <input type="text" id="inputEmail" name="username" class="form-control" placeholder="Username" />
            <br />

            <label for="inputPassword" class="sr-only">Password</label>
            <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" />

            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            <br>
            <br>
            <input value="Login" class="btn btn-lg btn-primary btn-block" type="submit" />
        </form>
        </div>
    </div>
</t:user_layout>