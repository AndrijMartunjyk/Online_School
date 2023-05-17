package main.controlers.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Lecture;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import web.dao.LectureDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/all_lectures")
public class ObjectsOfLecture extends HttpServlet {
    private final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lecture> lectureList = context.getBean("lectureDao", LectureDAO.class).showAllLectures();
        req.setAttribute("lectures", lectureList);
        req.getRequestDispatcher("/views/api_lecture/lecture_list.jsp").forward(req, resp);
    }
}
