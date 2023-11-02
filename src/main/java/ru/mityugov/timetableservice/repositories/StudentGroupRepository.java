package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.StudentGroup;

public interface StudentGroupRepository extends JpaRepository<StudentGroup, Integer> {
}
