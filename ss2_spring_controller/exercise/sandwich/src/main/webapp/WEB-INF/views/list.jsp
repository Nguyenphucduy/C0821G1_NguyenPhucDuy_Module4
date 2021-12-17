<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<h1>List Check Box</h1>
<body>
<c:if test="${listCheckBox != null}">
    <ul>
        <c:forEach items="${listCheckBox}" var="list">
            <li><c:out value="${list}"/></li>
        </c:forEach>
    </ul>
</c:if>
</body>
</html>
