package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Model;
import online_school.course.model.Person;


public abstract class Repository {
    private Model result;

    public Model getByldModel(long idModels, Model[] models) {
        for (Model model : models) {
            if (model == null) {
                break;
            } else if (model.getModelId() == idModels) {
                result = model;
            }
        }
        return result;
    }

    public void deleteModel(long id, Model[] object) {
        boolean isPresent = true;
        for (int i = 0; i < object.length; i++) {
            if (object[i] == null) {
                break;
            } else if (object[i].getModelId() == id) {
                object[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", id);
                for (int j = 0; j < object.length - 1; j++) {
                    if (object[j] == null) {
                        object[j] = object[j + 1];
                        object[j + 1] = null;
                    }
                }
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    public void deletePerson(long id, Person[] object) {
        boolean isPresent = true;
        for (int i = 0; i < object.length; i++) {
            if (object[i] == null) {
                break;
            } else if (object[i].getPersonId() == id) {
                object[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", id);
                for (int j = 0; j < object.length - 1; j++) {
                    if (object[j] == null) {
                        object[j] = object[j + 1];
                        object[j + 1] = null;
                    }
                }
                isPresent = false;
                break;
            }
        }
        if (isPresent) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    public void informPersonCourse(long courseId, Lecture[] lectures, Person[] students) {
        for (Lecture lecture : lectures) {
            for (Person student : students) {
                if (lecture == null || student == null) {
                    break;
                } else if (lecture.getModelId() == student.getLectureId() && lecture.getCourseID() == courseId) {
                    System.out.println(student);
                }
            }
        }
    }

    public void informPersonLecture(long lectureId, Lecture[] lectures, Person[] teachers) {
        for (Lecture lecture : lectures) {
            for (Person teacher : teachers) {
                if (lecture == null || teacher == null) {
                    break;
                } else if (lecture.getModelId() == teacher.getLectureId() && teacher.getLectureId() == lectureId) {
                    System.out.println(teacher);
                }
            }
        }
    }
}
