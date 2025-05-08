<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>

<h2>Multiplication</h2>

<form action="/q3" method="post">
    <label for="number1">Enter the first number:</label>
    <input type="text" id="number1" name="number1"><br><br>
    
    <label for="number2">Enter the second number:</label>
    <input type="text" id="number2" name="number2"><br><br>

    <label for="result">Enter the result of multiplication:</label>
    <input type="text" id="result" name="result"><br><br>

    <input type="submit" value="Submit">
</form>

<div>${message}</div>

</body>
</html>
