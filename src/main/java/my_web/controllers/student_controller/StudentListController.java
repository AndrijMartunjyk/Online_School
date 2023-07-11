package my_web.controllers.student_controller;

import my_web.service.StudentService;
import online_school.domain.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/student_list_page")
public class StudentListController {
    private final StudentService studentService;

    @Autowired
    public StudentListController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    private String getStudentList(Model model) {
        List<Student> studentList = studentService.getStudentList();
        model.addAttribute("students", studentList);
        return "/api_student/student_list";
    }
}
