<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.05.2023
  Time: 11:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add courses</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/course_css/add_course.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="body-flax">
<div class="container">
    <h2>Add Course</h2>
    <form action="${pageContext.request.contextPath}/add_course" method="post">
        <div>
            <label for="courseName">Course name:</label>
            <input type="text" name="courseName" id="courseName" required>
        </div>
        <%
            String courseName = "";
            if (request.getAttribute("courseName") != null) {
                courseName = request.getAttribute("courseName").toString() + " added";
            }
        %>

        <div>
            <input type="submit" value="Add">
        </div>
        <div class="massage"><%=courseName%>
        </div>

        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
                <li><a href="${pageContext.request.contextPath}/course_list">Back to course list</a></li>
            </ul>
        </nav>

    </form>

</div>
</body>
</html>
