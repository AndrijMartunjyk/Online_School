package main.controlers.courses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.dao.LectureDAO;
import online_school.domain.model.Lecture;
import web.dao.StudentDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-objects")
public class ObjectsOfCourse extends HttpServlet {
    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
    private final LectureDAO lectureDAO = context.getBean("lectureDao", LectureDAO.class);
    private final StudentDAO studentDAO = context.getBean("studentDao", StudentDAO.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("course_id"));

        List<Lecture> lectureList = lectureDAO.getLectureByCourseId(courseId);
        List<Person> personList = studentDAO.getStudentByCourseId(courseId);
        req.setAttribute("lecture_list", lectureList);
        req.setAttribute("person_list", personList);
        req.getRequestDispatcher("/views/api_course/objects_of_course.jsp").forward(req, resp);

    }
}
