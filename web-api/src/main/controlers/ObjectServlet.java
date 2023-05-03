package main.controlers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Person;
import web.dao.LectureDAO;
import online_school.domain.model.Lecture;
import web.dao.StudentDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/all-objects")
public class ObjectServlet extends HttpServlet {
    LectureDAO lectureDAO = new LectureDAO();
    StudentDAO studentDAO = new StudentDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int courseId = Integer.parseInt(req.getParameter("course_id"));

        List<Lecture> lectureList = lectureDAO.getLectureByCourseId(courseId);
        List<Person> personList = studentDAO.getStudentByCourseId(courseId);
        req.setAttribute("lecture_list", lectureList);
        req.setAttribute("person_list", personList);
        req.getRequestDispatcher("/api_other_objects/other_objects_page.jsp").forward(req, resp);

    }
}
