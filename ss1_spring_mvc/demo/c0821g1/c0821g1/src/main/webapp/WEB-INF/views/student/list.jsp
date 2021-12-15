<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/15/2021
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<table border="1">
    <tr>
        <td>Id</td>


    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td><c:out value="${student.id}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
