<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <tr>
        <td>Lettuce</td>
        <td>Tomato</td>
        <td>Mustard</td>
        <td>Sprouts</td>
    </tr>


        <tr>
            <c:forEach var="string" items="${stringList}">
            <td><c:out value="${string}"/></td>
<%--            <td><c:out value="${string}"/></td>--%>
<%--            <td><c:out value="${string}"/></td>--%>
<%--            <td><c:out value="${string}"/></td>--%>
            </c:forEach>
        </tr>

</table>
</body>
</html>
