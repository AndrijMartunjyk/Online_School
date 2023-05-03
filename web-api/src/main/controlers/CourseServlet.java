package main.controlers;

import web.dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Course;

import java.io.IOException;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {
    CourseDAO courseDAO = new CourseDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseDAO.courseList();
        req.setAttribute("course_list", courseList);
        req.getRequestDispatcher("/api_course/course_page.jsp").forward(req, resp);
    }
}
