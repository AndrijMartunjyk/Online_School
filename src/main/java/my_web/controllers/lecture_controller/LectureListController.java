package my_web.controllers.lecture_controller;

import my_web.service.LectureService;
import online_school.domain.model.Lecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lecture_list_page")
public class LectureListController {
    private final LectureService lectureService;

    @Autowired
    public LectureListController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping()
    public String getLectureList(Model model) {
        List<Lecture> lectureList = lectureService.getLectureList();
        model.addAttribute("lectures", lectureList);
        return "/api_lecture/lecture_list";
    }
}
