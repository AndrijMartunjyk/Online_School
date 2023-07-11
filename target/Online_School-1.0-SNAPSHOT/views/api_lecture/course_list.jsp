<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/course_list.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="container">
<h1>Courses List</h1>
<h4>Виберіть для якого курсу створити лекцію</h4>
<table border="1">
    <form action="/add_lecture" method="get">
        <thead>
        <tr>
            <th>Course Name</th>
            <th>Choose</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="apiExample" items="${course_list_for_lectures}">
            <tr class="tr">
                <td>${apiExample.courseName}</td>
                <td>
                    <label>
                        <input type="radio" name="course_id" value="${apiExample.courseId}" required>
                    </label>

                </td>
            </tr>
        </c:forEach>
        </tbody>
        <div><input type="submit"/></div>
    </form>
</table>
<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>

</body>
</html>