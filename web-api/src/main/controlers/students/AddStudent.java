package main.controlers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Role;
import online_school.service.StudentService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;

@WebServlet("/add_student")
public class AddStudent extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final StudentService studentService = context.getBean("studentService", StudentService.class);
    private String[] courseIdList;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        courseIdList = req.getParameterValues("course_id");
        if (courseIdList != null) {
            req.getRequestDispatcher("/views/api_student/add_student.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/views/api_student/student_not_found.jsp").forward(req, resp);
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        if (courseIdList != null) {
            String name = req.getParameter("first_name");
            String lastName = req.getParameter("last_name");
            String email = req.getParameter("email");
            String phone = req.getParameter("phone_number");
            List<String> listCourse = List.of(courseIdList);

            for (String courseId : listCourse) {
                studentService.createStudent(1L, name, lastName, email, phone, Role.STUDENT, 0L, Long.valueOf(courseId));
            }

            req.setAttribute("name", name);
            req.setAttribute("idCourseSize", listCourse.size());

        }
        req.getRequestDispatcher("/views/api_student/add_student.jsp").forward(req, resp);


    }
}
