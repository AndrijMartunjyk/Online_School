package my_web.controllers.student_controller;

import my_web.my_exeptions.MyEntityNotFoundException;
import my_web.service.StudentService;
import online_school.domain.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/add_student")
public class AddStudentController {

    private final StudentService studentService;
    private List<Long> courseIdList = new ArrayList<>();

    @Autowired
    public AddStudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public String getAddPage(@RequestParam(value = "course_id", defaultValue = "0") List<Long> idList) {
        if (idList.get(0) == 0) {
            throw new MyEntityNotFoundException(idList);
        }
        courseIdList = idList;
        return "/api_student/add_student";
    }

    @PostMapping()
    public String addStudent(@RequestParam("first_name") String name,
                             @RequestParam("last_name") String lastName,
                             @RequestParam("email") String email,
                             @RequestParam("phone_number") String tel, Model model) {
        for (long courseId : courseIdList) {
            studentService.addStudent(name, lastName, email, tel, Role.STUDENT, courseId);
        }
        model.addAttribute("name", name);
        model.addAttribute("idCourseSize", courseIdList.size());
        return "/api_student/add_student";
    }
}
