<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 08.05.2023
  Time: 20:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Add student</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/add_object.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="body-flax" >
<div class="container">
<h1>Added student</h1>
<form action="${pageContext.request.contextPath}/add_student" method="post">


    <label for="first_name">Name: </label><input type="text" id="first_name" name="first_name"
                                                 required> <br>
    <label for="last_name">Last Name:</label><input type="text" id="last_name" name="last_name"
                                                    required> <br>
    <label for="email">Email:</label><input type="email" id="email" name="email" autocomplete="on" required> <br>
    <label for="phone_number">Phone number:</label><input type="tel" id="phone_number"
                                                          placeholder="+3(___)___-__-__"
                                                          pattern="+3\s?[\(]{0,1}9[0-9]{2}[\)]{0,1}\s?\d{3}[-]{0,1}\d{2}[-]{0,1}\d{2}"
                                                          name="phone_number" required>
    <br>

    <div><input type="submit" value="Зберегти"/></div>



<%
    String message = "";
    if (request.getAttribute("name") != null) {
        String name = request.getAttribute("name").toString();
        String idCourseSize = request.getAttribute("idCourseSize").toString();
        message = "Студента " + "\"" + name + "\" додано до " + idCourseSize + " курсів";
    }
%>
<div class="massage" >
    <%=
    message
    %>
</div>

<nav>
    <ul>
        <li><a href="/course_list_for_students">Попередня сторінка</a></li>
        <li><a href="/all_students">Список студентів</a></li>
        <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
    </ul>
</nav>
</form>
</div>
</body>
</html>
