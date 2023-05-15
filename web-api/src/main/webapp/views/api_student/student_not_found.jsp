<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 10.05.2023
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html class="flax">
<head>
    <meta charset="UTF-8">
    <title>Course is not found</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/student_css/student_not_found.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="container">

<p>
    <strong>Ви не вибрали жодного курсу !!!
    </strong>
</p>

<nav>
    <ul>
        <li><a href="/course_list_for_students">Попередня сторінка</a></li>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>
</body>
</html>
