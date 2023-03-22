create database online_school;
USE online_school;
create table course
(
    courseId   INT AUTO_INCREMENT,
    courseName VARCHAR(20),
    PRIMARY KEY (`courseId`)
);
create table student
(
    studentId   INT AUTO_INCREMENT,
    firstName   VARCHAR(20),
    lastName    VARCHAR(40),
    email       VARCHAR(40) UNIQUE,
    phoneNumber VARCHAR(14),
    PRIMARY KEY (`studentId`)
);

create table student_courses
(
    courseId  INT NOT NULL,
    studentId INT NOT NULL,
    FOREIGN KEY (studentId) REFERENCES students (studentId),
    FOREIGN KEY (courseId) REFERENCES courses (courseId),
    UNIQUE (courseId, studentId)
);
create table teacher
(
    teacherId   INT AUTO_INCREMENT,
    firstName   VARCHAR(20),
    lastName    VARCHAR(40),
    email       VARCHAR(40) UNIQUE,
    phoneNumber VARCHAR(14),
    PRIMARY KEY (`teacherId`)
);
create table lecture
(
    lectureId     INT AUTO_INCREMENT,
    lectureName   VARCHAR(20),
    `description` VARCHAR(40),
    personId      LONG,
    courseId      LONG,
    creationDate  DATETIME,
    lectureDate   DATETIME,
    PRIMARY KEY (`lectureId`)
);
create table additionalMaterial
(
    resourceId INT AUTO_INCREMENT,
    `name`     VARCHAR(50),
    lectureId  LONG,
    PRIMARY KEY (`resourceId`)
);
create table home_work
(
    homeworkId INT AUTO_INCREMENT,
    lectureId  LONG,
    task       VARCHAR(400),
    PRIMARY KEY (`homeworkId`)
);

