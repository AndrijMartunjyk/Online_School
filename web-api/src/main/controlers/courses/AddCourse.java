package main.controlers.courses;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import online_school.service.CourseService;

import java.io.IOException;
@WebServlet("/add_course")
public class AddCourse extends HttpServlet {
   private CourseService courseService;
    public void init(){
        courseService=new CourseService();
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/views/api_course/add_course.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   String courseName=req.getParameter("courseName");
   courseService.createCourse(1L,courseName);
        req.setAttribute("courseName", courseName);
        doGet(req, resp);
    }
}