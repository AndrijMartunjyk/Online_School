package my_web.controllers.course_controller;

import my_web.service.CourseService;
import online_school.domain.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/course_list")
public class CourseListController {
    private final CourseService courseService;

    @Autowired
    public CourseListController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping("/for_course")
    public String getCourseList(Model model) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("course_list", courseList);
        return "/api_course/course_list";
    }

    @GetMapping("/for_lecture")
    public String getCourseListForLecture(Model model) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("course_list_for_lectures", courseList);
        return "/api_lecture/course_list";
    }

    @GetMapping("/for_student")
    public String getCourseListForStudent(Model model) {
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("course_list_for_students", courseList);
        return "/api_student/course_list";
    }
}
