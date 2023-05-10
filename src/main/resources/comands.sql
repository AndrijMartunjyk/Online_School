# MySql 1

# students have courses
# SELECT *
# FROM student_courses st_co
#          INNER JOIN course co ON co.course_id = st_co.course_id
#          INNER JOIN student st ON st_co.student_id = st.student_id;


# MySql 2

# 1 sorting by last name
SELECT *
FROM online_school.student
ORDER BY last_name;

# 2 name lecture and additional material numeric
SELECT lecture_name, COUNT(*)
FROM lecture l,
     additional_material ad
WHERE (l.lecture_date < '2023-6-30'
    AND l.lecture_id = ad.lecture_id)
GROUP BY l.lecture_name
LIMIT 1;

# 3 sorted by date
SELECT *
FROM lecture l
WHERE l.creation_date = ALL (SELECT MIN(creation_date)
                             FROM lecture);

# 3 which lecture has maximum numeric of homework
SELECT *
FROM lecture l
WHERE l.lecture_id = (SELECT lecture_id
                      FROM home_work hom
                      GROUP BY hom.lecture_id
                      ORDER BY COUNT(hom.lecture_id) DESC
                      LIMIT 1);

# 4 numeric additional materials by category
SELECT COUNT(resource_type) AS numeric_of_resource, `name`
FROM additional_material l
WHERE l.resource_type IN ('URL', 'VIDEO', 'BOOk')
GROUP BY `name`;

# 5 sorted teachers by first letter of last name from A to Н ukrainian alphabet
SELECT first_name, last_name
FROM teacher t
WHERE t.last_name BETWEEN 'А%' AND 'Н%'
ORDER BY t.last_name;


# 6 first name and last name of student
# SELECT first_name, last_name, COUNT(*) AS course_count
# FROM student
#          JOIN student_courses ON student.student_id = student_courses.student_id
# GROUP BY last_name, first_name
# HAVING course_count = 1
#     OR course_count = 2
#     OR course_count >= 3
# ORDER BY last_name;



# MySql 3

# 1 sorted by lecture date
SELECT DISTINCT lecture_name, first_name, last_name, lecture_date
FROM lecture l,
     teacher t
ORDER BY l.lecture_date;


# 2 the name of the teacher and the number of lectures he teach
SELECT last_name, first_name, COUNT(last_name) AS number_of_lectures
FROM teacher t
         INNER JOIN lecture l on t.teacher_id = l.teacher_id
GROUP BY last_name, first_name;

# 3 show all dates of all lectures, teacher id is 3
SELECT lecture_date, lecture_name
FROM lecture l
WHERE l.teacher_id = 3
ORDER BY lecture_date;


# 4 i don't know how should i do this task, i'm so sorry, i tried really, i don't feeling my brain, it exploded !!!!
SELECT course_name,
       COUNT(*) AS number_of_lecture,
       COUNT(*) AS number_of_teacher,
       COUNT(*) AS number_of_student,
       COUNT(*) AS number_of_home_work,
       COUNT(*) AS additional_material
FROM course c
         INNER JOIN lecture l on c.course_id = l.course_id
         INNER JOIN teacher t on c.course_id = t.course_id
         INNER JOIN student s on c.course_id = s.course_id
         INNER JOIN home_work hw on c.course_id = hw.course_id
         INNER JOIN additional_material am on c.course_id = am.course_id
GROUP BY course_name;


# 5 month name and numeric lecture
SELECT MONTHNAME(lecture.lecture_date), COUNT(*) AS numeric_of_lecture
FROM lecture
group by MONTHNAME(lecture.lecture_date);

# 6 name of data and number
SELECT (SELECT COUNT(*) FROM additional_material) AS numeric_of_additional_material,
       (SELECT COUNT(*) FROM home_work)           AS numeric_of_home_work;

#=================================================================================
# 44 homework
CREATE PROCEDURE table_name(IN table_name VARCHAR(50))
BEGIN
    SET @query = CONCAT('SELECT * FROM ', table_name);
    PREPARE statement_name FROM @query;
    EXECUTE statement_name;
    DEALLOCATE PREPARE statement_name;
END;