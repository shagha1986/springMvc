<%@ page import="java.util.List" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h1>Employees List Using Spring JdbcTemplate</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Age</th>
        <th>Salary</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <td>${emp.id}</td>
            <td>${emp.name}</td>
            <td>${emp.age}</td>
            <td>${emp.salary}</td>

            <td><a href="editemp/${emp.id}">Edit</a></td>
            <td><a href="deleteemp/${emp.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<div>
    <p>pagination here</p>


    <c:forEach var="i" begin="1" end="3">
        <a href="/viewEmployees/${i}"><c:out value="${i}"></c:out></a>
    </c:forEach>

</div>
<br/>

<a href="/addemp">Add New Employee</a>

</body>
</html>
