package controllers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Course;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.service.CourseService;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;


@WebServlet("/course_list_for_students")
public class CourseList extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final CourseService courseService = context.getBean(CourseService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courseList = courseService.getCourseList();
        req.setAttribute("course_list_for_students", courseList);
        req.getRequestDispatcher("/views/api_student/course_list.jsp").forward(req, resp);
    }


}

