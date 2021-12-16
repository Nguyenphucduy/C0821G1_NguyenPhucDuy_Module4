<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/16/2021
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/student/create" method="post">
    <p>id: </p>
    <input name="id">
    <p>name: </p>
    <input name="name">
    <p>Date of birth</p>
    <input type="date" name="dateOfBirth">
    <p>Gender</p>
    <input name="gender">
    <p>Grade</p>
    <input name="grade">
    <button type="submit">Create</button>
</form>
</body>
</html>
