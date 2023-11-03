package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.Lesson;

public interface LessonRepository extends JpaRepository<Lesson, Integer> {
}
