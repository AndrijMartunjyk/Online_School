package main.controlers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Course;
import web.dao.CourseDAO;

import java.io.IOException;
import java.util.List;


@WebServlet("/course_list_for_students")
public class CourseList extends HttpServlet {
    private final CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseDAO.courseList();
        req.setAttribute("course_list_for_students", courseList);
        req.getRequestDispatcher("/views/api_student/course_list.jsp").forward(req, resp);
    }


}

