package main.controlers.courses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.dao.CourseDAO;
import web.utils.MyConfig;

import java.io.IOException;

@WebServlet("/add_course")
public class AddCourse extends HttpServlet {

    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final CourseDAO courseDAO = context.getBean("courseDAO", CourseDAO.class);


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/api_course/add_course.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String courseName = req.getParameter("courseName");
        courseDAO.createCourse(courseName);
        req.setAttribute("courseName", courseName);
        doGet(req, resp);
    }
}
