<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Courses</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/course_css/course_list.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="container">
<h1>Courses List</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Course Name</th>
        <th>Follow the link</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${course_list}">
        <tr class="tr">
            <td>${apiExample.courseId}</td>
            <td>${apiExample.courseName}</td>
            <td><a href="/inform_about_course/${apiExample.courseId}">Вся інформація про курс
            </a></td>
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
