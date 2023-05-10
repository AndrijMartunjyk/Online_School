package main.controlers.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.service.LectureService;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/add_lecture")
public class AddLecture extends HttpServlet {
   private LectureService lectureService;
private int courseId;
    public void init() {
        lectureService = new LectureService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/api_lecture/add_lecture.jsp").forward(req, resp);
        courseId = Integer.parseInt(req.getParameter("course_id"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lectureName = req.getParameter("lecture_name");
        String description = req.getParameter("description");

        String dateLecture = req.getParameter("date");


        lectureService.createLecture(1L, lectureName, description, (long) courseId, LocalDateTime.parse(dateLecture));

        req.setAttribute("lectureName", lectureName);
        doGet(req, resp);
    }
}
