package main.controlers.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Course;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.dao.CourseDAO;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;

@WebServlet("/course_list_for_lectures")
public class CourseList extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final CourseDAO courseDAO = context.getBean("courseDAO", CourseDAO.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseDAO.courseList();
        req.setAttribute("course_list_for_lectures", courseList);
        req.getRequestDispatcher("/views/api_lecture/course_list.jsp").forward(req, resp);
    }
}
