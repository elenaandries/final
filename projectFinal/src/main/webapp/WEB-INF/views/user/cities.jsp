<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>

<t:layout>
    <div class="row">
    <div class="col-xs-6">
    <form>
        <div class="form-group">
            <label class="col-sm-2 control-label">City</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="city" placeholder="Enter city">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>

    <table class="responsive table">
        <tr>
            <th>Name</th>
            <th>Country</th>
            <th>Options</th>
        </tr>

        <c:forEach var="city" items="${cities}">
            <tr>
                <td><a href="/user/cities?id=<c:out value="${city.getId()}"/>"><c:out value="${city.getName()}"/></a></td>
                <td><c:out value="${city.getCountry().getName()}"/></td>
                <td>
                    <a href="/city/${city.getId()}/update">Edit</a>
                    <a href="/city/${city.getId()}/delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="col-xs-6">

        <c:choose>
            <c:when test="${not empty selectedCity}">
                <p>Weather for <c:out value="${selectedCity.getName()}"/></p>
                <c:choose>
                    <c:when test="${not empty forecast}">
                        <table class="responsive table">
                            <tr>
                                <th>Temp</th>
                                <th>Min. temp</th>
                                <th>Max. temp</th>
                                <th>Pressure</th>
                                <th>Humidity</th>
                                <th>Wind speed</th>
                            </tr>
                            <c:forEach var="hourlyForecast" items="${forecast.getList()}">
                                <tr>
                                    <td><c:out value="${hourlyForecast.getMain().getTemp()}"/></td>
                                    <td><c:out value="${hourlyForecast.getMain().getTemp_min()}"/></td>
                                    <td><c:out value="${hourlyForecast.getMain().getTemp_max()}"/></td>
                                    <td><c:out value="${hourlyForecast.getMain().getPressure()}"/></td>
                                    <td><c:out value="${hourlyForecast.getMain().getHumidity()}"/></td>
                                    <td><c:out value="${hourlyForecast.getWind().getSpeed()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                </c:choose>
            </c:when>
        </c:choose>
    </div>
</t:layout>

