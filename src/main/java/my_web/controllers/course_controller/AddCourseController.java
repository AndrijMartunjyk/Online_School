package my_web.controllers.course_controller;

import my_web.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/page_with_add")
public class AddCourseController {
    private final CourseService courseService;

    @Autowired
    public AddCourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping()
    public String getPageWithAdd() {
        return "/api_course/add_course";
    }

    @PostMapping()
    public String addCourse(@RequestParam("name") String courseName, Model model) {
        courseService.addCourse(courseName);
        model.addAttribute("course_name", courseName);
        return "/api_course/add_course";
    }
}
