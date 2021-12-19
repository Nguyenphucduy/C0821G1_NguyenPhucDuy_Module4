<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Information</title>
</head>
<body>
<h2>Config Email Information</h2>
<table>
    <tr>
        <td>
            Language :
        </td>
        <td>
            <c:out value="${configEmail.language}"/>

        </td>
    </tr>
    <tr>
        <td>
            Page Size:
        </td>
        <td>
            <c:out value="${configEmail.pageSize}"/>
        </td>
    </tr>
    <tr>
        <td>
            Spams Filter :
        </td>
        <td>
            <c:out value="${configEmail.spamsFilter}"/>
        </td>
    </tr>
    <tr>
        <td>
            Signature :
        </td>
        <td>
            <c:out value="${configEmail.signature}"/>
        </td>
    </tr>

</table>
</body>
</html>