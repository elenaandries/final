<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page session="true"%>

<t:layout>
<div class="container">
    <form>
        <div class="form-group">
            <label class="col-sm-2 control-label">City</label>
            <div class="col-sm-5">
                <input type="text" class="form-control" id="exampleInputName2" placeholder="Enter city">

            </div>
            <button type="submit" class="btn btn-primary">Check</button>
            <button type="submit" class="btn btn-primary">Save</button>
        </div>

    </form>
</div>

</t:layout>

