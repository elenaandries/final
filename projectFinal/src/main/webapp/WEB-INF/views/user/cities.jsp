<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>

<t:layout>
    <div class="row">
    <div class="col-xs-4">
    <form method="post" action="/user/cities/add">
        <div class="form-group">
            <label class="col-sm-2 control-label">City</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" name="name" placeholder="Enter city">
            </div>
            <button type="submit" class="btn btn-primary">Add</button>
        </div>

    </form>

    <table class="responsive table">
        <tr>
            <th>Name</th>
            <th>Options</th>
        </tr>

        <c:forEach var="city" items="${cities}">
            <tr>
                <td><a href="/user/cities?id=<c:out value="${city.getId()}"/>"><c:out value="${city.getName()}"/></a></td>
                <td>
                    <a href="/city/${city.getId()}/delete">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </div>
    <div class="col-xs-7">

        <c:choose>
            <c:when test="${not empty selectedCity}">
                <p>Weather for <c:out value="${forecast.getCity().getName()}"/></p>
                <c:choose>
                    <c:when test="${not empty forecast}">
                        <table class="responsive table" id="second">
                            <tr>
                                <th>Date</th>
                                <th>Temp°</th>
                                <th>Min. temp°</th>
                                <th>Max. temp°</th>
                                <th>Pressure(hPa)</th>
                                <th>Humidity(%)</th>
                            </tr>

                            <c:set var="previous_date" value="" scope="page" />
                            <c:forEach var="hourlyForecast" items="${forecast.getList()}">

                                <c:if test="${previous_date != hourlyForecast.getDay()}">
                                   <tr>
                                       <td colspan="7"><strong><c:out value="${hourlyForecast.getDay()}"/></strong></td>
                                   </tr>
                                </c:if>
                                    <c:set var="previous_date" value="${hourlyForecast.getDay()}" scope="page" />
                                <tr>
                                    <td class="text-center"><c:out value="${hourlyForecast.timestampToString()}"/></td>
                                    <td class="text-center"><c:out value="${hourlyForecast.getMain().getTemp()}"/></td>
                                    <td class="text-center"><c:out value="${hourlyForecast.getMain().getTemp_min()}"/></td>
                                    <td class="text-center"><c:out value="${hourlyForecast.getMain().getTemp_max()}"/></td>
                                    <td class="text-center"><c:out value="${hourlyForecast.getMain().getPressure()}"/></td>
                                    <td class="text-center"><c:out value="${hourlyForecast.getMain().getHumidity()}"/></td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:when>
                </c:choose>
            </c:when>
        </c:choose>
    </div>
</t:layout>

