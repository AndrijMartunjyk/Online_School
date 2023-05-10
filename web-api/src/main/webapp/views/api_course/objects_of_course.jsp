<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Objects</title>
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
    <c:forEach var="apiExample" items="${lecture_list}">
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
        <th>Course Id</th>
        <th>Lecture Id</th>
        <th>Phone Number</th>
        <th>Email</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${person_list}">
        <tr>
            <td>${apiExample.personId}</td>
            <td>${apiExample.firstPersonName}</td>
            <td>${apiExample.lastPersonName}</td>
            <td>${apiExample.role}</td>
            <td>${apiExample.courseId}</td>
            <td>${apiExample.lectureId}</td>
            <td>${apiExample.phone}</td>
            <td>${apiExample.email}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
        <li><a href="${pageContext.request.contextPath}/course_list">Back to Course List</a></li>
    </ul>
</nav>
</body>
</html>
