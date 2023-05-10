<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10.05.2023
  Time: 16:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Students</title>
</head>
<body class="container">
<h1>Students</h1>
<table border="1">
    <thead>
    <tr>
        <th>Student ID</th>
        <th>Name</th>
        <th>Last Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Role</th>
        <th>Lecture Id</th>
        <th>Course Id</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${students}">
        <tr>
            <td>${apiExample.personId}</td>
            <td>${apiExample.firstPersonName}</td>
            <td>${apiExample.lastPersonName}</td>
            <td>${apiExample.email}</td>
            <td>${apiExample.phone}</td>
            <td>${apiExample.role}</td>
            <td>${apiExample.lectureId}</td>
            <td>${apiExample.courseId}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
        <li><a href="views/api_student/student_page.jsp">Back to student page</a></li>
    </ul>
</nav>

</body>
</html>
