package main.controlers.courses;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.dao.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Course;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;

@WebServlet("/course_list")
public class CourseList extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final CourseDAO courseDAO = context.getBean("courseDAO", CourseDAO.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseDAO.courseList();
        req.setAttribute("course_list", courseList);
        req.getRequestDispatcher("/views/api_course/course_list.jsp").forward(req, resp);
        context.close();
    }
}
