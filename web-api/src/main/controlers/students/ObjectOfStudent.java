package main.controlers.students;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.dao.StudentDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/all_students")
public class ObjectOfStudent extends HttpServlet {
    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Person> studentList = context.getBean("studentDao", StudentDAO.class).showAllStudents();
        req.setAttribute("students", studentList);
        req.getRequestDispatcher("/views/api_student/student_list.jsp").forward(req, resp);
    }
}
