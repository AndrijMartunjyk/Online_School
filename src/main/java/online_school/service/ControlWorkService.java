package online_school.service;

import online_school.domain.model.Role;
import online_school.domain.control_work.Student;
import online_school.log.Log;

import java.util.List;
import java.util.Optional;

public class ControlWorkService {
    public Student[] createStudentsArray() {
        Log.debug(ControlWorkService.class.getName(), "method-> \"createStudentsArray\"");
        return new Student[]{new Student(Role.STUDENT, 1L, "Андрій", "Мартинюк", "«+38(044)555-55-55»", "«anick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Олександр", "Гавриленко", "«+38(044)555-55-55»", "«bnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Ірина", "Степанюк", "«+38(044)555-55-55»", "«cnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Олег", "Мисливчук", "«+38(044)555-55-55»", "«dnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Володимир", "Зеленський", "«+38(044)555-55-55»", "«inick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Володимир", "Гройсман", "«+38(044)555-55-55»", "«fnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Андрій", "Парубій", "«+38(044)555-55-55»", "«gnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Петро", "Порошенко", "«+38(044)555-55-55»", "«onick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Валерій", "Залужний", "«+38(044)555-55-55»", "«pnick@mail.com»"),
                new Student(Role.STUDENT, 1L, "Юлія", "Тимошенко", "«+38(044)555-55-55»", "«qnick@mail.com»")};
    }

    public void creatNumberTaskForStudent(Student[] students) {
        Optional<Student[]> studentsOptional = Optional.ofNullable(students);
        if (studentsOptional.isPresent()) {
            for (int i = 0; i < studentsOptional.get().length; i++) {
                byte result = (byte) (1 + Math.random() * 10);
                for (Student student : studentsOptional.get()) {
                    if (student.getTaskNumber() == 0 && student.getTaskNumber() != result) {
                        student.setTaskNumber(result);
                        break;
                    } else if (student.getTaskNumber() == result) {
                        i--;
                        break;
                    }
                }
            }
        }
        Log.debug(ControlWorkService.class.getName(), "method-> \"creatTaskForStudent\"");
    }

    public void startControlWork(List<Student> listStudents, Student[] studentsArray) throws InterruptedException {
        Optional<Student[]> optionalStudents = Optional.ofNullable(studentsArray);
        Optional<List<Student>> optionalStudentList = Optional.ofNullable(listStudents);
        if (optionalStudents.isPresent() && optionalStudentList.isPresent()) {
            Thread thread;
            for (int i = 0; i < optionalStudents.get().length; i++) {
                thread = new Thread(optionalStudentList.get().get(i));
                thread.start();
            }
            Thread.sleep(1000);
            sortedStudents(optionalStudentList.get());
            for (byte i = 12; i > 0; i--) {
                Thread.sleep(1000);
                System.out.println(i);
                Log.info(ControlWorkService.class.getName(), String.valueOf(i));
            }
            for (int i = 0; i < optionalStudentList.get().size(); i++) {
                if (optionalStudentList.get().get(i).getTime() <= 12) {
                    optionalStudentList.get().get(i).setStudentNumber(i + 1);
                    System.out.printf("Студент: %d %s %s // час -> %d сек.\n", optionalStudentList.get().get(i).getStudentNumber(),
                            optionalStudentList.get().get(i).getFirstPersonName(), optionalStudentList.get().get(i).getLastPersonName(), optionalStudentList.get().get(i).getTime());
                    Log.info(ControlWorkService.class.getName(), "Студент: " + optionalStudentList.get().get(i).getStudentNumber() + " "
                            + optionalStudentList.get().get(i).getFirstPersonName() + optionalStudentList.get().get(i).getLastPersonName()
                            + " // час -> " + optionalStudentList.get().get(i).getTime() + " сек.\n");
                } else {
                    System.out.printf("Студент: %s %s // НЕ ВСТИГ(ЛА)!!! час -> %d сек.\n",
                            optionalStudentList.get().get(i).getFirstPersonName(), optionalStudentList.get().get(i).getLastPersonName(), optionalStudentList.get().get(i).getTime());
                    Log.info(ControlWorkService.class.getName(), "Студент: " + optionalStudentList.get().get(i).getFirstPersonName()
                            + optionalStudentList.get().get(i).getLastPersonName() + " // НЕ ВСТИГ(ЛА)!!! час -> " + optionalStudentList.get().get(i).getTime() + " сек.\n");
                }
            }
        }

        Log.debug(ControlWorkService.class.getName(), "method-> \"startControlWork\"");
    }

    private void sortedStudents(List<Student> listStudents) {
        listStudents.sort((o1, o2) -> {
            int result = 1;
            if (o1.hashCode() == o2.hashCode() && o1.equals(o2)) {
                result = 0;
            } else if (o1.getTime() < o2.getTime()) {
                result = -1;
            }
            return result;
        });
        Log.debug(ControlWorkService.class.getName(), "method-> \"sortedStudents\"");
    }
}
