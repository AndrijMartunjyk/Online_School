package controllers.lectures;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.domain.model.Lecture;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import web.service.LectureService;
import web.utils.MyConfig;

import java.io.IOException;
import java.util.List;

@WebServlet("/all_lectures")
public class ObjectsOfLecture extends HttpServlet {
    private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
    private final LectureService lectureService = context.getBean(LectureService.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Lecture> lectureList = lectureService.getLectureList();
        req.setAttribute("lectures", lectureList);
        req.getRequestDispatcher("/views/api_lecture/lecture_list.jsp").forward(req, resp);
    }
}
