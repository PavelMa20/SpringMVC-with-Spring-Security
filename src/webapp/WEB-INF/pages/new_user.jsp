<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>New User</title>
</head>
<body>
<div align="center">
    <h2>New User</h2>
    <%--@elvariable id="user" type="java"--%>
    <form:form action="add" method="post" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>Name: </td>
                <td><form:input path="name" /></td>
            </tr>
            <tr>
                <td>LastName: </td>
                <td><form:input path="lastName" /></td>
            </tr>
            <tr>
                <td>Password: </td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td>Age: </td>
                <td><form:input path="age" /></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Add"></td>
            </tr>
        </table>
    </form:form>
    <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form>
</div>
</body>
</html>
