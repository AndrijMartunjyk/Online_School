<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body class="container">
<h3>Виберіть для якого курсу створити лекцію</h3>
<h4>Courses List</h4>
<form action="${pageContext.request.contextPath}/add_lecture" method="get">
    <table border="1">
        <thead>
        <tr>
            <th>Course Name</th>
            <th>Choose</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="apiExample" items="${course_list_for_lectures}">
            <tr>
                <td>${apiExample.courseName}</td>
                <td>
                    <label>
                        <input type="radio" name="course_id" value="${apiExample.courseId}" required>
                    </label>

                </td>
            </tr>
        </c:forEach>
        </tbody>

    </table>
    <div><input type="submit"/></div>
</form>

<nav>
    <ul>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>

</body>
</html>