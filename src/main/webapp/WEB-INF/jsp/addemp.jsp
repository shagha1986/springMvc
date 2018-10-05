<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>Add New Employee</h1>
<form:form method="post" action="/save">
    <table >
        <tr>
            <td>Name : </td>
            <td><form:input path="name"  /></td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td><form:input path="salary" /></td>
        </tr>
        <tr>
            <td>Age :</td>
            <td><form:input path="age" /></td>
        </tr>
        <tr>
            <td> </td>
            <td><input type="submit" value="Save it!" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
