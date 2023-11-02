-- dictionary-tables
create table degree
(
    id   int generated by default as identity primary key,
    name varchar not null
);

create table lesson_type
(
    id   int generated by default as identity primary key,
    name varchar not null
);

-- main tables
create table subject
(
    id                        int generated by default as identity primary key,
    name                      varchar not null,
    description               varchar not null,
    laboratory_academic_hours int,
    practical_academic_hours  int,
    lecture_academic_hours    int     not null,
    course_academic_hours     int
);

create table teacher
(
    id         int generated by default as identity primary key,
    surname    varchar(100)               not null,
    name       varchar(100)               not null,
    patronymic varchar(100),
    degree     int references degree (id) not null
);

create table student_group
(
    id   int generated by default as identity primary key,
    name varchar(50) not null
);

create table lesson
(
    id             int generated by default as identity primary key,
    lesson_type_id int references lesson_type (id) not null,
    time_date      timestamp                       not null,
    subject_id     int references subject (id)     not null
);

create table student
(
    id               int generated by default as identity primary key,
    surname          varchar(100)                      not null,
    name             varchar(100)                      not null,
    patronymic       varchar(100),
    student_group_id int references student_group (id) not null
);

-- many-to-many tables
create table lesson_for_student_group
(
    student_group_id int references student_group (id) not null,
    lesson_id        int references lesson (id)       not null
);

create table subject_for_student_group
(
    student_group_id int references student_group (id) not null,
    subject_id       int references subject (id)       not null
);

create table subject_for_teacher
(
    subject_id int references subject (id) not null,
    teacher_id int references teacher (id) not null
);