INSERT INTO online_school.courses(courseName)
VALUES ('Java'),
       ('Python'),
       ('Java Script');

INSERT INTO online_school.students(firstName, lastName, email, phoneNumber)
VALUES ('Joey', 'Trebiani', 'asd@gmail.com', 0921234567),
       ('Joey1', 'Trebian1i', 'asdf@gmail.com', 0921234567),
       ('Joey2', 'Trebiani2', 'asdg@gmail.com', 0921234567),
       ('Joey3', 'Trebiani3', 'asdh@gmail.com', 0921234567),
       ('Joey4', 'Trebiani4', 'asdj@gmail.com', 0921234567),
       ('Joey5', 'Trebiani8', 'asde@gmail.com', 0921234567);
INSERT INTO online_school.student_courses(courseId, studentId)
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (2, 3),
       (3, 4),
       (3, 5),
       (3, 36);

INSERT INTO online_school.teacher(firstName, lastName, email, phoneNumber)
VALUES ('Ольга', 'Батьківна', 'asd@gmail.com', 123456789);

INSERT INTO online_school.lecture(lectureName)
VALUES ('MySql');

INSERT INTO online_school.additionalmaterial(name)
VALUES ('url address');

INSERT INTO online_school.home_work(task)
VALUES ('study,study,study and study again !!!');

SELECT *
FROM student_courses st_co
         INNER JOIN courses co ON co.courseId = st_co.courseId
         INNER JOIN students st ON st_co.studentId = st.studentId;