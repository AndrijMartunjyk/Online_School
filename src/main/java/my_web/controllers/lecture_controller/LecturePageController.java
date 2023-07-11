package my_web.controllers.lecture_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lecture_page")
public class LecturePageController {
    @GetMapping()
    public String getLecturePage() {
        return "/api_lecture/lecture_page";
    }
}
