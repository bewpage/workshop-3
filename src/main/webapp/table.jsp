<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="table-responsive">
    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
        <thead>
        <tr>
            <th>ID</th>
            <th>Username</th>
            <th>Email</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${users}" var="user">
            <tr>
                <td><c:out value="${user.id}"/></td>
                <td><c:out value="${user.username}"/></td>
                <td><c:out value="${user.email}"/></td>
                <td class="text-left py-1 px-0">
                    <div>
                        <button type="button" class="btn btn-link" data-toggle="modal"
                                data-target="#exampleModal" id="delete_btn">Delete
                        </button>
                        <button type="button" class="btn btn-link" id="edit_btn">Edit</button>
                        <button type="button" class="btn btn-link" id="show_btn">Show
                        </button>
                    </div>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

<!-- modal.jsp -->
<%@include file="/modal.jsp" %>