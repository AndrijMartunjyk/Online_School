<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Courses</title>
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
        <tr>
            <td>${apiExample.courseId}</td>
            <td>${apiExample.courseName}</td>
            <td><a href="${pageContext.request.contextPath}/all-objects?course_id=${apiExample.courseId}">Вся інформація про курс
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
