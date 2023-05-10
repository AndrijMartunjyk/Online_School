create database online_school;
USE online_school;
create table course
(
    course_id   BIGINT AUTO_INCREMENT,
    course_name VARCHAR(50),
    PRIMARY KEY (course_id)
);
create table student
(
    PRIMARY KEY (`student_id`),
    student_id   INT AUTO_INCREMENT UNIQUE,
    first_name   VARCHAR(20),
    last_name    VARCHAR(40),
    email        VARCHAR(40),
    phone_number VARCHAR(14),
    `role`       ENUM ('STUDENT'),
    lecture_id   LONG,
    course_id    LONG
);

create table student_courses
(
    PRIMARY KEY (student_id, course_id),
    student_id INT NOT NULL,
    course_id  INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student (student_id),
    FOREIGN KEY (course_id) REFERENCES course (course_id)
);
create table teacher
(
    teacher_key  INT PRIMARY KEY AUTO_INCREMENT,
    teacher_id   VARCHAR(20) UNIQUE,
    first_name   VARCHAR(20),
    last_name    VARCHAR(40),
    email        VARCHAR(40) UNIQUE,
    phone_number VARCHAR(14),
    `role`       ENUM ('TEACHER'),
    lecture_id   LONG,
    course_id    LONG
);

create table lecture
(
    PRIMARY KEY (`lecture_id`),
    lecture_id    INT AUTO_INCREMENT,
    lecture_name  VARCHAR(20),
    `description` VARCHAR(40),
    teacher_id    LONG,
    course_id     LONG,
    creation_date DATETIME,
    lecture_date  DATETIME
);
create table additional_Material
(
    PRIMARY KEY (`resource_id`),
    resource_id   INT AUTO_INCREMENT,
    `name`        VARCHAR(50),
    lecture_id    LONG,
    resource_type ENUM ('URL','BOOk','VIDEO'),
    course_id     LONG
);
create table home_work
(
    PRIMARY KEY (`homework_id`),
    homework_id INT AUTO_INCREMENT,
    lecture_id  LONG,
    task        VARCHAR(400),
    course_id   LONG
);

