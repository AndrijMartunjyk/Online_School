package my_web.controllers.student_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student_page")
public class StudentPageController {
    @GetMapping()
    public String getStudentPage() {
        return "/api_student/student_page";
    }
}
