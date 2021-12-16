<%--
  Created by IntelliJ IDEA.
  User: LENOVO
  Date: 12/15/2021
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Student List</h1>
<p><a href="/student/create">Create Student</a> </p>
<p style="color: blue">${msg}</p>
<table border="1" style="width: 500px">
    <tr>
        <th>No</th>
        <th>Id</th>
        <th>Name</th>
        <th>Date of birth</th>
        <th>Rank</th>
        <th>Gender</th>
        <th colspan="2">Action</th>
    </tr>
    <c:forEach var="studentObj" items="${students}" varStatus="loop">
        <tr>
            <td><c:out value="${loop.count}"/></td>
            <td><c:out value="${studentObj.id}"/></td>
            <td><c:out value="${studentObj.name}"/></td>
            <td><c:out value="${studentObj.dateOfBirth}"/></td>
            <td>
                <c:choose>
                    <c:when test="${studentObj.grade < 5}">
                        Bad
                    </c:when>
                    <c:when test="${studentObj.grade < 8}">
                        Good
                    </c:when>
                    <c:otherwise>
                        Excellent
                    </c:otherwise>
                </c:choose>
            </td>
            <td>
                <c:if test="${studentObj.gender == 0}">
                    Female
                </c:if>
                <c:if test="${studentObj.gender == 1}">
                    Male
                </c:if>
            </td>
            <td><a href="/student/detail/${studentObj.id}/${studentObj.name}">Detail Student</a> </td>
            <td><a href="/student/detail?id=${studentObj.id}&name=${studentObj.name}">Detail Student</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
