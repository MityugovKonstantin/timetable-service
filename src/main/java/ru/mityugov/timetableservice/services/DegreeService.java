package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.Degree;
import ru.mityugov.timetableservice.repositories.DegreeRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class DegreeService {
    private final DegreeRepository degreeRepository;

    @Autowired
    public DegreeService(DegreeRepository degreeRepository) {
        this.degreeRepository = degreeRepository;
    }

    public List<Degree> findAll() {
        return degreeRepository.findAll();
    }

    public Degree findById(int id) {
        return degreeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Degree degree) {
        degreeRepository.save(degree);
    }

    @Transactional
    public void update(int id, Degree updatedDegree) {
        updatedDegree.setId(id);
        degreeRepository.save(updatedDegree);
    }

    @Transactional
    public void delete(int id) {
        degreeRepository.deleteById(id);
    }
}
