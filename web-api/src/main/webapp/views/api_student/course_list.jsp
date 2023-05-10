<%--
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
</head>
<body class="container">
<h3>Виберіть до якого курсу додати студента</h3>
<h4>Courses List</h4>
<form action="${pageContext.request.contextPath}/add_student" method="get">
    <table border="1">
        <thead>
        <tr>
            <th>Course Name</th>
            <th>Choose</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="apiExample" items="${course_list_for_students}">
            <tr>
                <td>${apiExample.courseName}</td>
                <td><label>
                    <input type="checkbox" name="course_id" value="${apiExample.courseId}">
                </label></td>
            </tr>
        </c:forEach>
        </tbody>

    </table>

    <div><input type="submit" value="Додати"/></div>
</form>
<div>

</div>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>

</body>
</html>
