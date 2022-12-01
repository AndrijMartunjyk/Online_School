package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.generic.SchoolArray;
import online_school.service.TeacherService;
import online_school.course.model.Person;

public class TeacherRepository extends Repository {
    private final SchoolArray<Person> teachersArray = new SchoolArray<>(new Person[1]);

    public int teacherCounter() {
        int result = 0;
        for (Person teacher : teachersArray.getArray()) {
            if (teacher == null) {
                break;
            } else {
                result = TeacherService.getTeacherCounter();
            }
        }
        return result;
    }

    public boolean searchTeacher(long teacherId, long lectureId, Lecture[] lecture) {
        boolean trueOrFalse = true;
        for (Person teacher : teachersArray.getArray()) {
            if (teacher != null && teacher.getPersonId() == teacherId) {
                for (Lecture value : lecture) {
                    if (value != null && value.getModelId() == lectureId) {
                        value.setPersonId(teacherId);
                        value.setFirstName(teacher.getFirstName());
                        value.setLastName(teacher.getLastName());
                        teacher.setLectureId(value.getModelId());
                        teacher.setLectureName(value.getName());
                        System.out.printf("Вчителя з номером ID: \"%d\" присвоєно лекції з номером ID: \"%d\"\n", teacherId, lectureId);
                        trueOrFalse = true;
                        break;
                    }
                }
            } else {
                trueOrFalse = false;
            }
        }
        return trueOrFalse;
    }

    public SchoolArray<Person> getTeachersArrayObject() {
        return teachersArray;
    }

    public Person[] getTeacherArray() {
        return teachersArray.getArray();
    }

    public void add(Person teacher) {
        teachersArray.add(teacher);

    }

    public long getTeacherId() {
        return teachersArray.getArray()[teacherCounter() - 1].getPersonId();
    }
}
