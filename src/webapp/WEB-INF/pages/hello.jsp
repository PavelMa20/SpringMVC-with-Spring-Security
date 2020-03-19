<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Hello user</title>
</head>
<body>
<div align="center">
    <h2>Hello!</h2>
    <%--@elvariable id="user" type="java"--%>
    <form:form action="hello" method="get" modelAttribute="user">
        <table border="0" cellpadding="5">
            <tr>
                <td>ID: </td>
                <td>${user.id}
                    <form:hidden path="id"/>
                </td>
            </tr>
            <tr>
                <td>Name: </td>
                <td>${user.name}
                    <form:hidden path="name"/>
                </td>
            </tr>
            <tr>
                <td>LastName: </td>
                <td>${user.lastName}
                    <form:hidden path="lastName"/>
                </td>
            </tr>
            <tr>
                <td>Password: </td>
                <td>${user.password}
                    <form:hidden path="password"/>
                </td>
            </tr>
            <tr>
                <td>Age: </td>
                <td>${user.age}
                    <form:hidden path="age"/>
                </td>
            </tr>
        </table>
    </form:form>
    <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form>
</div>
</body>
</html>




