create database online_school;
USE online_school;
create table course
(
    course_id   INT AUTO_INCREMENT,
    course_name VARCHAR(20),
    PRIMARY KEY (course_id)
);
create table student
(
    student_id   INT AUTO_INCREMENT,
    first_name   VARCHAR(20),
    last_name    VARCHAR(40),
    email        VARCHAR(40) UNIQUE,
    phone_number VARCHAR(14),
    `role`       ENUM ('STUDENT'),
    lecture_id   LONG,
    course_id    LONG,
    PRIMARY KEY (`student_id`)
);

create table student_courses
(
    student_id INT NOT NULL,
    course_id  INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id),
    PRIMARY KEY (student_id, course_id)
);
create table teacher
(
    teacher_id   INT AUTO_INCREMENT,
    first_name   VARCHAR(20),
    last_name    VARCHAR(40),
    email        VARCHAR(40) UNIQUE,
    phone_number VARCHAR(14),
    `role`       ENUM ('TEACHER'),
    lecture_id   LONG,
    PRIMARY KEY (`teacher_id`)
);
create table lecture
(
    lecture_id    INT AUTO_INCREMENT,
    lecture_name  VARCHAR(20),
    `description` VARCHAR(40),
    teacher_id    LONG,
    course_id     LONG,
    creation_date DATETIME,
    lecture_date  DATETIME,
    PRIMARY KEY (`lecture_id`)
);
create table additional_Material
(
    resource_id   INT AUTO_INCREMENT,
    `name`        VARCHAR(50),
    lecture_id    LONG,
    resource_type ENUM ('URL','BOOk','VIDEO'),
    PRIMARY KEY (`resource_id`)
);
create table home_work
(
    homework_id INT AUTO_INCREMENT,
    lecture_id  LONG,
    task        VARCHAR(400),
    PRIMARY KEY (`homework_id`)
);

