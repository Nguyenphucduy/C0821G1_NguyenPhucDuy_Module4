<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h1>Calculator</h1>
<form action="/calculator" method="post">
    <span>
      <input type="number" name="number1">
      <input type="number" name="number2">
    </span>
    <p>
        <input type="submit" value="Addition(+)" name="addition">
        <input type="submit" value="Subtraction(-)" name="subtraction">
        <input type="submit" value="Multiplication(*)" name="multiplication">
        <input type="submit" value="Division(/)" name="division">
    </p>
</form>
<h3 style="color: blue">Result : ${result}</h3>
</body>
</html>
