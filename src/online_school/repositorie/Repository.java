package online_school.repositorie;

import online_school.course.model.Lecture;
import online_school.course.model.Model;
import online_school.course.model.Person;

public abstract class Repository {
    public Model[] getAll() {
        return null;
    }

    public void add(Model models) {
        new Model();
    }

    public Model getByldModel(long idModels, Model[] models) {
        Model modelsResult = null;
        for (Model model : models) {
            if (model == null) {
                break;
            } else if (model.getID() == idModels) {
                modelsResult = model;
            }
        }
        return modelsResult;
    }

    public Model getByldPerson(long idModels, Person[] persons) {
        Model modelsResult = null;
        for (Person person : persons) {
            if (person == null) {
                break;
            } else if (person.getPersonId() == idModels) {
                modelsResult = person;
            }
        }
        return modelsResult;
    }

    public void deleteByldPerson(long idTeachers, Person[] teachers) {
        boolean trueOrFalse = true;
        for (int i = 0; i < teachers.length; i++) {
            if (teachers[i] == null) {
                break;
            } else if (teachers[i].getPersonId() == idTeachers) {
                teachers[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", idTeachers);
                for (int j = 0; j < teachers.length - 1; j++) {
                    if (teachers[j] == null) {
                        teachers[j] = teachers[j + 1];
                        teachers[j + 1] = null;
                    }
                }
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    public void deleteByldModel(long idModels, Model[] models) {
        boolean trueOrFalse = true;
        for (int i = 0; i < models.length; i++) {
            if (models[i] == null) {
                break;
            } else if (models[i].getID() == idModels) {
                models[i] = null;
                System.out.printf("Об'єкт з номером ID: \"%d\" видалено!!!\n", idModels);
                for (int j = 0; j < models.length - 1; j++) {
                    if (models[j] == null) {
                        models[j] = models[j + 1];
                        models[j + 1] = null;
                    }
                }
                trueOrFalse = false;
                break;
            }
        }
        if (trueOrFalse) {
            System.out.println("Не має об'єкта з таким ID, спробуйте ще раз!!!");
        }
    }

    public void informPersonCourse(long courseId, Lecture[] lectures, Person[] students) {
        for (Lecture lecture : lectures) {
            for (Person student : students) {
                if (lecture == null || student == null) {
                    break;
                } else if (lecture.getID() == student.getLectureId() && lecture.getCourseID() == courseId) {
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
                } else if (lecture.getID() == teacher.getLectureId() && teacher.getLectureId() == lectureId) {
                    System.out.println(teacher);
                }
            }
        }
    }
}
