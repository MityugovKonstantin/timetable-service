package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
