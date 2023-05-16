<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<form method="post">
    <div class="form-group">
        <label for="username">Username</label>
        <input type="text" class="form-control" id="username" placeholder="username" name="username"
               value="<c:out value="${user.username}" />" required>
    </div>
    <div class="form-group">
        <label for="email">Email</label>
        <input type="email" class="form-control" id="email" aria-describedby="email address" name="email"
               value="<c:out value="${user.email}" />" required>
    </div>
    <div class="form-group">
        <label for="password">Password</label>
        <input type="password" class="form-control" id="password" name="password" placeholder="user password" required>
    </div>
    <button type="submit" class="btn btn-primary">Edit</button>
</form>