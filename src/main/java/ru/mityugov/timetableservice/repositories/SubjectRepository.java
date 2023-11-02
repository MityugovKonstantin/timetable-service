package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
}
