<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ include file="/header.jsp" %>
<!-- Header -->

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- Page Heading -->
    <%@include file="mainHeading.jsp" %>

    <!-- Content Row -->
    <div class="row">
        <!-- Content Column -->
        <div class="col-lg-12 mb-4">
            <!-- Content Card -->
            <div class="card shadow mb-4">
                <div class="card-header py-3">
                    <h6 class="m-0 font-weight-bold text-primary">User info</h6>
                </div>
                <div class="card-body">
                    <!-- New User Form -->
                    <c:catch var="exception">
                        <c:if test="${not empty exception}">
                            <div class="alert alert-danger">
                                <p>${exception}</p>
                            </div>
                        </c:if>
                        <c:if test="${exception == null}" >
                            <%@include file="showUser.jsp" %>
                        </c:if>
                    </c:catch>

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
