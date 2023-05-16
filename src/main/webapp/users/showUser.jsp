<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<ul class="list-group list-group-flush">
    <li class="list-group-item">
        <div class="row">
            <div class="col-6 font-weight-bold">ID</div>
            <div class="col-6"><c:out value="${user.id}"/></div>
        </div>
    </li>
    <li class="list-group-item">
        <div class="row">
            <div class="col-6 font-weight-bold">Username</div>
            <div class="col-6"><c:out value="${user.username}"/></div>
        </div>
    </li>
    <li class="list-group-item">
        <div class="row">
            <div class="col-6 font-weight-bold">Email</div>
            <div class="col-6"><c:out value="${user.email}"/></div>
        </div>
    </li>
</ul>