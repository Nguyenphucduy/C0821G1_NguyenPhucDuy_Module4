<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>translate dictionary</h1>

<form  method="post" action="/dictionary"  >
    <fieldset>
        <legend>translate dictionary</legend>
        <table>
            <tr>
                <td>input word: </td>
                <td><input type="text" name="word" ></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="submit" value="dictionary"></td>
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
