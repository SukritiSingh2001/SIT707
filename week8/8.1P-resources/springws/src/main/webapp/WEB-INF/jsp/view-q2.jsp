<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Math Question 2</title>
</head>
<body>

<h2>Q2: What is the result of subtraction?</h2>

<c:if test="${not empty message}">
    <div style="color:red;">${message}</div><br/><br/>
</c:if>

<form method="post" action="/q2">
    <label>Number 1:</label>
    <input type="text" name="number1" required/><br/><br/>
    
    <label>Number 2:</label>
    <input type="text" name="number2" required/><br/><br/>

    <label>Your Answer (number1 - number2):</label>
    <input type="text" name="result" required/><br/><br/>

    <input type="submit" value="Submit"/>
</form>

</body>
</html>
