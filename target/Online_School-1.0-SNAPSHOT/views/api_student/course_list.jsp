<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.05.2023
  Time: 20:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Courses List</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/course_list.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="container">
<h1>Courses List</h1>
<h4>Виберіть до якого курсу додати студента</h4>
<table border="1">
    <form action="/add_student" method="get">
        <thead>
        <tr>
            <th>Course Name</th>
            <th>Choose</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="apiExample" items="${course_list_for_students}">
            <tr class="tr">
                <td>${apiExample.courseName}</td>
                <td><label>
                    <input type="checkbox" name="course_id" value="${apiExample.courseId}">
                </label></td>
            </tr>
        </c:forEach>
        </tbody>
        <div><input type="submit" value="Додати"/></div>
    </form>
</table>
<div>

</div>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>

</body>
</html>
