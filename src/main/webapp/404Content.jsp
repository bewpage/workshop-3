<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 404 Error Text -->
<div class="text-center">
    <c:set var="requestError" value="${requestScope['javax.servlet.error.status_code']}"/>
    <c:set var="requestException" value="${requestScope['javax.servlet.error.exxception']}"/>
    <c:set var="requestMessage" value="${requestScope['javax.servlet.error.message']}"/>
    <div class="error mx-auto" data-text="${requestError}"><c:out
            value="${requestError}"/></div>
    <p class="lead text-gray-800 mb-5">${requestException}</p>
    <p class="text-gray-500 mb-0">It looks like you found a glitch in the matrix...</p>
    <a href="<c:url value="/user/list" />">&larr; Back to Dashboard</a>
</div>