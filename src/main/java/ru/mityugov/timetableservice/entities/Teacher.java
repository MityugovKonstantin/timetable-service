package ru.mityugov.timetableservice.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "surname")
    @NotEmpty(message = "Surname should not be empty!")
    @Size(min = 1, max = 100, message = "Surname should not be less than 1 and more than 100 characters!")
    private String surname;

    @Column(name = "name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 1, max = 100, message = "Name should not be less than 1 and more than 100 characters!")
    private String name;

    @Column(name = "patronymic")
    @Size(max = 100, message = "Name should not be more than 100 characters!")
    private String patronymic;

    @ManyToOne
    @JoinColumn(name = "degree_id", referencedColumnName = "id")
    private Degree degree;

    public Teacher () {}

    public Teacher(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Degree getDegree() {
        return degree;
    }

    public void setDegree(Degree degree) {
        this.degree = degree;
    }

    public String getFullName() {
        return surname + " " + name + " " + (patronymic != null ? patronymic : "");
    }
}
