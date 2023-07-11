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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/list.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="container">
<h1>Lectures</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Lecture Name</th>
        <th>Description</th>
        <th>creationDate</th>
        <th>lectureDate</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${lectures}">
        <tr class="tr">
            <td>${apiExample.lectureId}</td>
            <td>${apiExample.lectureName}</td>
            <td>${apiExample.description}</td>
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