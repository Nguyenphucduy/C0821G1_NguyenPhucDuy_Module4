<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Settings</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="info_config" method="post" modelAttribute="configEmail">
    <fieldset>
        <legend>Config Email</legend>
        <table>
            <tr>
             <td>
                 Language :

             </td>
                <td>
                    <form:select path="language">
                        <form:options items="${language}"/>;
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    Page Size :

                </td>
                <td>
                    <form:select path="pageSize">
                        <form:options items="${pageSize}"/>;
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    SpamsFilter :

                </td>
                <td>
                    <form:radiobutton path="spamsFilter" value="on"/> enable spams filter
                </td>
            </tr>
            <tr>

                <td>
                    Signature :
                </td>
                <td>
                    <form:textarea path="signature"/>
                </td>
            </tr>
            <tr>
                <td><form:button>Update</form:button></td>
            </tr>
        </table>
    </fieldset>
</form:form>
</body>
</html>
