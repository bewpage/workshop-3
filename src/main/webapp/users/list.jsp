<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>
<!-- Header -->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- User List Header -->
    <%@include file="listHeading.jsp" %>

    <!-- Content Row -->
    <div class="row">
        <!-- Content Column -->
        <div class="col-lg-12 mb-4">
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">Users List</h6>
                </div>
                <div class="card-body">
                    <!-- Users List Table -->
                    <c:if test="${not empty users}">
                        <%@include file="/table.jsp" %>
                    </c:if>
                    <c:if test="${empty users}">
                        <div class="alert alert-danger" role="alert">
                            <strong>Oops!</strong> No users found.
                        </div>
                    </c:if>
                </div>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

</div>
<!-- End of Main Content -->

<!-- Footer -->
<%@include file="/footer.jsp" %>
