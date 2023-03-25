# students have courses
SELECT *
FROM student_courses st_co
         INNER JOIN course co ON co.course_id = st_co.course_id
         INNER JOIN student st ON st_co.student_id = st.student_id;

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
SELECT COUNT(resource_type), `name`
FROM additional_material l
WHERE l.resource_type IN ('URL', 'VIDEO', 'BOOk')
GROUP BY `name`;

# 5 sorted teachers by first letter of last name from A to Н ukrainian alphabet
SELECT first_name, last_name
FROM teacher t
WHERE t.last_name BETWEEN 'А%' AND 'Н%'
ORDER BY t.last_name;


# 6 first name and last name of student
SELECT first_name, last_name, COUNT(*) AS course_count
FROM student
         JOIN student_courses ON student.student_id = student_courses.student_id
GROUP BY last_name, first_name
HAVING course_count = 1
    OR course_count = 2
    OR course_count >= 3
ORDER BY last_name;
