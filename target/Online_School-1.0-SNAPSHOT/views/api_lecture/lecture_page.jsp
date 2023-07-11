<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 06.05.2023
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Lectures page</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/two_page.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap" rel="stylesheet">
</head>
<header class="header-box">
    <h1>Lectures</h1>
</header>
<body>
<nav class="nav-box">
    <a class="nav" href="/course_list/for_lecture">Add lecture</a>
    <a class="nav" href="/lecture_list_page">List of lectures</a>
</nav>
<nav class="nav-box2">
    <a class="nav2" href="${pageContext.request.contextPath}/">Головна</a>
</nav>
</body>
</html>
