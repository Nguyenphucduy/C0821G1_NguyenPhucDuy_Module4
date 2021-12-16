<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12/16/2021
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Sandwich Condiments</h1>

<form action="/sandwich" method="post">
    <table>
        <tr>
            <td>Lettuce</td>
            <td>
                <input type="checkbox" name="lettuce">
            </td>
        </tr>
        <tr>
            <td>Tomato</td>
            <td>
                <input type="checkbox" name="tomato">
            </td>
        </tr>
        <tr>
            <td>Mustard</td>
            <td>
                <input type="checkbox" name="mustard">
            </td>
        </tr>
        <tr>
            <td>Sprouts</td>
            <td>
                <input type="checkbox" name="sprouts">
            </td>
        </tr>
        <tr>
            <td></td>
            <td>
                <input type="submit" value="Save">
            </td>
        </tr>

    </table>
</form>
</body>
</html>
