-- Degree
insert into degree (name) values ('Кандидат технических наук');
insert into degree (name) values ('Доктор технических наук');

-- LessonType
insert into lesson_type (name) values ('Лабораторная работа');
insert into lesson_type (name) values ('Практическая работа');
insert into lesson_type (name) values ('Лекция');
insert into lesson_type (name) values ('Курсовая работа');

-- Subject
insert into subject (name, description, laboratory_academic_hours, lecture_academic_hours)
    values ('ИОиМОвЭ', 'Исследование операций и методов оптимизации в экономике', 12, 24);
insert into subject (name, description, practical_academic_hours, lecture_academic_hours, course_academic_hours)
    values ('МиИМЭП', 'Математическое и иммитационное модлирование экономических процессов', 12, 12, 12);
insert into subject (name, description, practical_academic_hours, lecture_academic_hours, course_academic_hours)
    values ('БД', 'Базы данных', 12, 12, 12);

-- Teacher
insert into teacher (surname, name, patronymic, degree_id)
    values ('Мицель', 'Артур', 'Эдуардович', 2);
insert into teacher (surname, name, degree_id)
    values ('Яблонский', 'Ян', 2);

-- StudentGroup
insert into student_group (name) values ('440-1');
insert into student_group (name) values ('441-1');
insert into student_group (name) values ('441-2');

-- Lesson
insert into lesson (lesson_type_id, time_date, subject_id)
    values (1, '2023-11-7 8:00:00', 1);
insert into lesson (lesson_type_id, time_date, subject_id)
    values (1, '2023-11-7 9:45:00', 1);
insert into lesson (lesson_type_id, time_date, subject_id)
    values (3, '2023-11-7 11:30:00', 2);
insert into lesson (lesson_type_id, time_date, subject_id)
    values (1, '2023-11-7 8:00:00', 3);
insert into lesson (lesson_type_id, time_date, subject_id)
    values (1, '2023-11-7 9:45:00', 3);
insert into lesson (lesson_type_id, time_date, subject_id)
    values (3, '2023-11-7 11:30:00', 2);

-- Student
insert into student (surname, name, patronymic, student_group_id)
    values ('Макаронинка', 'Степан', 'Максимович', 1);
insert into student (surname, name, student_group_id)
    values ('Голышкин', 'Роман', 1);
insert into student (surname, name, patronymic, student_group_id)
    values ('Ивановов', 'Иван', 'Иваныч', 2);
insert into student (surname, name, patronymic, student_group_id)
    values ('Кузнецов', 'Никита', 'Сергеевич', 2);

-- LessonForStudentGroup
insert into lesson_for_student_group values (1, 1);
insert into lesson_for_student_group values (1, 2);
insert into lesson_for_student_group values (1, 3);
insert into lesson_for_student_group values (2, 4);
insert into lesson_for_student_group values (2, 5);
insert into lesson_for_student_group values (2, 6);

-- subject_for_student_group
insert into subject_for_student_group values (1, 1);
insert into subject_for_student_group values (2, 2);
insert into subject_for_student_group values (2, 3);
insert into subject_for_student_group values (3, 2);
insert into subject_for_student_group values (3, 3);

-- subject_for_teacher
insert into subject_for_teacher values (1, 1);
insert into subject_for_teacher values (2, 1);
insert into subject_for_teacher values (3, 2);