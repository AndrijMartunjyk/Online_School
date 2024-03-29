<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en" class="flex-box">
<head>
    <link rel="stylesheet"type="text/css" href="${pageContext.request.contextPath}/css/shared_css/two_page.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@600&display=swap" rel="stylesheet">
    <title>Courses</title>

</head>
<header class="header-box">
    <h1>Courses page</h1>
</header>
<body>
<nav class="nav-box">
    <a class="nav" href="/page_with_add">Add course</a>
    <a class="nav" href="/course_list/for_course">List of courses</a>
</nav>
<nav class="nav-box2">
    <a class="nav2" href="${pageContext.request.contextPath}/">Головна</a>
</nav>
</body>
</html>
