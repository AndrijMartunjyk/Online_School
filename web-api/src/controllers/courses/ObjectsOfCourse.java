package controllers.courses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Student;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import online_school.domain.model.Lecture;
import web.service.LectureService;
import web.service.StudentService;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-objects")
public class ObjectsOfCourse extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final LectureService lectureService = context.getBean(LectureService.class);
    private final StudentService studentService = context.getBean(StudentService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("course_id"));


        List<Lecture> lectureList = lectureService.getLectureListByCourseId((long) courseId);
        List<Student> studentList = studentService.getStudentListByCourseId((long) courseId);
        req.setAttribute("lecture_list", lectureList);
        req.setAttribute("student_list", studentList);
        req.getRequestDispatcher("/views/api_course/objects_of_course.jsp").forward(req, resp);
    }
}
