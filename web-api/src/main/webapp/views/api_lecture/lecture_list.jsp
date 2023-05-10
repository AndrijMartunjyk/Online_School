<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.05.2023
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Lectures</title>
</head>
<body class="container">
<h1>Lectures</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lecture Name</th>
        <th>Description</th>
        <th>Course Id</th>
        <th>creationDate</th>
        <th>lectureDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${lectures}">
        <tr>
            <td>${apiExample.lectureId}</td>
            <td>${apiExample.lectureName}</td>
            <td>${apiExample.description}</td>
            <td>${apiExample.courseId}</td>
            <td>${apiExample.creationDate}</td>
            <td>${apiExample.lectureDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <li>
            <a href="${pageContext.request.contextPath}/">Back to Home Page</a>
        </li>
    </ul>
</nav>

</body>
</html>