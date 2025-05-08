<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Login</title>
</head>
<body>

<h2>Login Page</h2>

<!-- Display error message if available -->
<c:if test="${not empty message}">
    <div style="color:red;">${message}</div><br/><br/>
</c:if>

<form method="post" action="/login">
    <label>Username:</label>
    <input type="text" name="username" required/><br/><br/>

    <label>Password:</label>
    <input type="password" name="passwd" required/><br/><br/>

    <label>DOB:</label>
    <input type="date" name="dob" required/><br/><br/>

    <input type="submit" value="Login"/>
</form>

</body>
</html>
