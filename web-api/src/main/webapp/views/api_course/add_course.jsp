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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/styles.css">
</head>
<body>
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
        <div><%=courseName%>
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
