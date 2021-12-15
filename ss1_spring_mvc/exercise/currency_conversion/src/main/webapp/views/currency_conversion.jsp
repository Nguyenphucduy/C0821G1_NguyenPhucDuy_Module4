<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<form  method="post" action="/currency"  >
    <fieldset>
        <legend>Currency Conversion</legend>
        <table>
            <tr>
                <td>USD: </td>
                <td><input type="number" name="usd" ></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="Calculator"></td>
            </tr>
            <tr>
                <td>Result: </td>
                <td style="color: blue"><c:out value="${result}"/></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>
