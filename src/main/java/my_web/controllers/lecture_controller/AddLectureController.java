package my_web.controllers.lecture_controller;

import my_web.my_exeptions.MyEntityNotFoundException;
import my_web.service.LectureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.Collections;

@Controller
@RequestMapping("/add_lecture")
public class AddLectureController {
    private long courseId;
    private final LectureService lectureService;

    @Autowired
    public AddLectureController(LectureService lectureService) {
        this.lectureService = lectureService;
    }

    @GetMapping()
    private String getAddLecturePage(@RequestParam(value = "course_id",defaultValue = "0")  long id) {
        if (id==0){
            throw new MyEntityNotFoundException(Collections.singletonList(id));
        }
        courseId = id;
        return "/api_lecture/add_lecture";
    }

    @PostMapping()
    public String addLecture(@RequestParam("lecture_name") String lectureName,
                             @RequestParam("description") String description,
                             @RequestParam("dateLecture") String dateLecture, Model model) {
        lectureService.addLecture(lectureName, description, courseId, LocalDateTime.parse(dateLecture));
        model.addAttribute("lectureName", lectureName);
        return "/api_lecture/add_lecture";
    }
}
