
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>List of Students</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/list.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
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
    </tr>
    </thead>
    <tbody>
    <c:forEach var="apiExample" items="${students}">
        <tr class="tr">
            <td>${apiExample.studentId}</td>
            <td>${apiExample.firstName}</td>
            <td>${apiExample.lastName}</td>
            <td>${apiExample.email}</td>
            <td>${apiExample.phone}</td>
            <td>${apiExample.role}</td>
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
