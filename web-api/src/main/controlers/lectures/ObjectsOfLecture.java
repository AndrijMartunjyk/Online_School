package main.controlers.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Lecture;
import web.dao.LectureDAO;

import java.io.IOException;
import java.util.List;

@WebServlet("/all_lectures")
public class ObjectsOfLecture extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lecture> lectureList = new LectureDAO().showAllLectures();
        req.setAttribute("lectures", lectureList);
        req.getRequestDispatcher("/views/api_lecture/lecture_list.jsp").forward(req, resp);
    }
}
