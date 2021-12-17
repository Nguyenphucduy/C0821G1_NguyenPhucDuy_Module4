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
                <input type="checkbox" value="lettuce" name="listCheckBox">
            </td>
        </tr>
        <tr>
            <td>Tomato</td>
            <td>
                <input type="checkbox" value="tomato" name="listCheckBox">
            </td>
        </tr>
        <tr>
            <td>Mustard</td>
            <td>
                <input type="checkbox" value="mustard" name="listCheckBox">
            </td>
        </tr>
        <tr>
            <td>Sprouts</td>
            <td>
                <input type="checkbox" value="sprouts" name="listCheckBox">
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
