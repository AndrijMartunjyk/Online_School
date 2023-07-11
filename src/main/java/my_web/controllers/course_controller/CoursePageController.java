package my_web.controllers.course_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/course_page")
public class CoursePageController {
    @GetMapping
    public String getCoursePage() {
        return "/api_course/course_page";
    }
}
