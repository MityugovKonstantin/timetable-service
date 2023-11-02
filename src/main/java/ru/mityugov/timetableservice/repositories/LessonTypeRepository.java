package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.LessonType;

public interface LessonTypeRepository extends JpaRepository<LessonType, Integer> {
}
