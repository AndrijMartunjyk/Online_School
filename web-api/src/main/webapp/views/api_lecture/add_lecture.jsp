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
    <title>Add lecture</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/shared_css/add_object.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@500&display=swap" rel="stylesheet">
</head>
<body class="body-flax">
<div class="container">
    <h1>Add Lecture</h1>
    <form action="${pageContext.request.contextPath}/add_lecture" method="post">
        <div>
            <form method="post">
                <label for="lecture_name">Lecture name: </label><input type="text" id="lecture_name" name="lecture_name"
                                                                       required> <br>
                <label for="description">Description:</label><input type="text" id="description" name="description"
                                                                    required> <br>
                <label for="date">Date lecture:</label><input type="datetime-local" id="date" name="date" required> <br>
                <div><input type="submit" value="Зберегти"/></div>

            </form>
        </div>
        <%
            String lectureName = "";
            if (request.getAttribute("lectureName") != null) {
                lectureName = "Лекцію " + "\"" + request.getAttribute("lectureName").toString() + "\"" + " додано";
            }
        %>
        <div class="massage"><%=lectureName%>
        </div>

        <nav>
            <ul>
                <li><a href="${pageContext.request.contextPath}/">Back to Home Page</a></li>
                <li><a href="${pageContext.request.contextPath}/all_lectures">Back to lecture list</a></li>
            </ul>
        </nav>


    </form>

</div>
</body>
</html>
