package my_web.controllers.course_controller;

import online_school.domain.model.Lecture;
import online_school.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import my_web.service.LectureService;
import my_web.service.StudentService;

import java.util.List;

@Controller
@RequestMapping("/inform_about_course")
public class ObjectOfCourseController {
    private final LectureService lectureService;
    private final StudentService studentService;

    @Autowired
    public ObjectOfCourseController(LectureService lectureService, StudentService studentService) {
        this.lectureService = lectureService;
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public String getObjectsOfCourse(@PathVariable("id") int courseId, Model model) {
        List<Lecture> lectureList = lectureService.getLectureListByCourseId((long) courseId);
        List<Student> studentList = studentService.getStudentListByCourseId((long) courseId);

        model.addAttribute("lecture_list", lectureList);
        model.addAttribute("student_list", studentList);
        return "/api_course/objects_of_course";
    }
}
