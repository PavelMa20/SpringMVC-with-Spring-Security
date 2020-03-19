<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>User Manager</h2>
    <h3><a href="/admin/new">New User</a></h3>
    <table border="1" cellpadding="5">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>LastName</th>
            <th>Password</th>
            <th>Age</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${listUser}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.lastName}</td>
                <td>${user.password}</td>
                <td>${user.age}</td>
                <td>
                    <a href="/admin/edit?id=${user.id}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/admin/delete?id=${user.id}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form action="/logout" method="post">
        <input value="Logout" type="submit">
    </form>
</div>
</body>
</html>