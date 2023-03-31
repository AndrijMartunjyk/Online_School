INSERT INTO online_school.course(course_name)
VALUES ('Java'),
       ('Python'),
       ('Java Script'),
       ('C++'),
       ('Scala');

INSERT INTO online_school.student(first_name, last_name, email, phone_number, `role`, lecture_id, course_id)
VALUES ('Андрій', 'Парубій', 'asd@gmail.com', 0921234567, 'STUDENT', 1, 2),
       ('Валерій', 'Залужний', 'rsdf@gmail.com', 0921234567, 'STUDENT', 1, 3),
       ('Вєрка', 'Сердючка', 'gsddfgg@gmail.com', 0921234567, 'STUDENT', 2, 2),
       ('Вєрка', 'Сердючка', 'gxcfzsdg@gmail.com', 0921234567, 'STUDENT', 2, 3),
       ('Вєрка', 'Сердючка', 'gzxdg@gmail.com', 0921234567, 'STUDENT', 2, 4),
       ('Петро', 'Третій', 'jsdh@gmail.com', 0921234567, 'STUDENT', 3, 1),
       ('Михайло', 'Тайсон', 'esttdj@gmail.com', 0921234567, 'STUDENT', 4, 1),
       ('Степан', 'Бандера', 'lddsde@gmail.com', 0921234567, 'STUDENT', 2, 1),
       ('Степан', 'Бандера', 'lsdeddd@gmail.com', 0921234567, 'STUDENT', 2, 4);

INSERT INTO online_school.student_courses(student_id, course_id)
VALUES (1, 1),
       (2, 2),
       (3, 2),
       (2, 3),
       (3, 4),
       (3, 5);

INSERT INTO online_school.teacher(teacher_id, first_name, last_name, email, phone_number, role, lecture_id, course_id)
VALUES (1, 'Ольга', 'Кличко', 'asd@gmail.com', 123456789, 'TEACHER', 1, 1),
       (2, 'Іра', 'Тайсон', 'dasd@gmail.com', 123456789, 'TEACHER', 2, 2),
       (3, 'Люда', 'Фюрі', 'wasd@gmail.com', 123456789, 'TEACHER', 3, 3),
       (4, 'Надія', 'Усик', 'yasd@gmail.com', 123456789, 'TEACHER', 4, 4),
       (5, 'Ольга', 'Алі', 'qasd@gmail.com', 123456789, 'TEACHER', 5, 5);


INSERT INTO online_school.lecture(lecture_name, `description`, teacher_id, course_id, creation_date, lecture_date)
VALUES ('MySql', 'вивчення бази данних', 1, 1, '2020-1-23 12:00', '2022-5-29 12:00'),
       ('Junit', 'вивчення тестування', 2, 2, '2020-2-23 12:00', '2023-5-27 12:00'),
       ('method', 'вивчення методів', 3, 3, '2020-3-23 12:00', '2022-5-25 12:00'),
       ('Docker', 'вивчення docker', 4, 4, '2020-4-23 12:00', '2023-5-23 12:00'),
       ('Maven', 'Maven, встановлення', 5, 5, '2020-5-23 12:00', '2023-6-30 12:00');
INSERT INTO online_school.lecture(lecture_name, `description`, teacher_id, course_id, creation_date, lecture_date)
VALUES ('Junit', 'вивчення тестування', 3, 2, '2020-2-23 12:00', '2023-5-27 12:00'),
       ('method', 'вивчення методів', 1, 3, '2020-3-23 12:00', '2022-5-25 12:00'),
       ('Docker', 'вивчення docker', 3, 4, '2020-4-23 12:00', '2023-5-23 12:00');


INSERT INTO online_school.additional_material(`name`, lecture_id, resource_type, course_id)
VALUES ('url address', 1, 'URL', 1),
       ('books', 2, 'BOOk', 3),
       ('books', 2, 'BOOk', 4),
       ('video materials', 1, 'VIDEO', 1),
       ('books', 3, 'BOOk', 2),
       ('video', 1, 'VIDEO', 4),
       ('video', 1, 'VIDEO', 1),
       ('video', 4, 'VIDEO', 5),
       ('url address', 5, 'URL', 3);

INSERT INTO online_school.home_work(lecture_id, task, course_id)
VALUES (4, 'study,study,study and study again !!!', 2),
       (1, 'study,study,study and study again !!!', 4),
       (5, 'study,study,study and study again !!!', 3),
       (2, 'study,study,study and study again !!!', 1),
       (3, 'study,study,study and study again !!!', 5),
       (1, 'study,study,study and study again !!!', 4),
       (5, 'study,study,study and study again !!!', 3),
       (1, 'study,study,study and study again !!!', 3);

