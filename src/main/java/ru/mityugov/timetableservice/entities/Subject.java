package ru.mityugov.timetableservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

@Entity
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Name should not be empty!")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Description should not be empty!")
    @Column(name = "description")
    private String description;

    @Min(value = 0, message = "Hours should be more then 0!")
    @Column(name = "laboratory_academic_hours")
    private Integer laboratoryAcademicHours;

    @Min(value = 0, message = "Hours should be more then 0!")
    @Column(name = "practical_academic_hours")
    private Integer practicalAcademicHours;

    @Min(value = 0, message = "Hours should be more then 0!")
    @Column(name = "lecture_academic_hours")
    private Integer lectureAcademicHours;

    @Min(value = 0, message = "Hours should be more then 0!")
    @Column(name = "course_academic_hours")
    private Integer courseAcademicHours;

    @OneToMany(mappedBy = "subject")
    private List<Lesson> lessons;

    public Subject() {}

    public Subject(
        String name, String description,
        Integer laboratoryAcademicHours,
        Integer practicalAcademicHours,
        Integer lectureAcademicHours,
        Integer courseAcademicHours,
        List<Lesson> lessons
    ) {
        this.name = name;
        this.description = description;
        this.laboratoryAcademicHours = laboratoryAcademicHours;
        this.practicalAcademicHours = practicalAcademicHours;
        this.lectureAcademicHours = lectureAcademicHours;
        this.courseAcademicHours = courseAcademicHours;
        this.lessons = lessons;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLaboratoryAcademicHours() {
        return laboratoryAcademicHours;
    }

    public void setLaboratoryAcademicHours(Integer laboratoryAcademicHours) {
        this.laboratoryAcademicHours = laboratoryAcademicHours;
    }

    public Integer getPracticalAcademicHours() {
        return practicalAcademicHours;
    }

    public void setPracticalAcademicHours(Integer practicalAcademicHours) {
        this.practicalAcademicHours = practicalAcademicHours;
    }

    public Integer getLectureAcademicHours() {
        return lectureAcademicHours;
    }

    public void setLectureAcademicHours(Integer lectureAcademicHours) {
        this.lectureAcademicHours = lectureAcademicHours;
    }

    public Integer getCourseAcademicHours() {
        return courseAcademicHours;
    }

    public void setCourseAcademicHours(Integer courseAcademicHours) {
        this.courseAcademicHours = courseAcademicHours;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
