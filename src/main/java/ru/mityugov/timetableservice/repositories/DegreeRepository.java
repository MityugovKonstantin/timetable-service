package ru.mityugov.timetableservice.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mityugov.timetableservice.entities.Degree;

public interface DegreeRepository extends JpaRepository<Degree, Integer> {
}
