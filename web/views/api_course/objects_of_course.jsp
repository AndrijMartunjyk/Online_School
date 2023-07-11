<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Objects</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/course_css/objects_of_course.css">
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
    <c:forEach var="apiExample" items="${lecture_list}">
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
</body>

<body class="container">
<h1>Students</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Student Name</th>
        <th>Student Last Name</th>
        <th>Role</th>
        <th>Phone Number</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${student_list}">
        <tr class="tr">
            <td>${apiExample.studentId}</td>
            <td>${apiExample.firstName}</td>
            <td>${apiExample.lastName}</td>
            <td>${apiExample.role}</td>
            <td>${apiExample.phone}</td>
            <td>${apiExample.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
        <li><a href="/course_list/for_course">Back to Course List</a></li>
    </ul>
</nav>
</body>
</html>
