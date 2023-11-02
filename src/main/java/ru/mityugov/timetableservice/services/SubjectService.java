package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.Subject;
import ru.mityugov.timetableservice.repositories.SubjectRepository;

import java.util.List;

@Service
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Autowired
    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    public Subject findById(int id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Subject subject) {
        subjectRepository.save(subject);
    }

    @Transactional
    public void update(int id, Subject updatedSubject) {
        updatedSubject.setId(id);
        subjectRepository.save(updatedSubject);
    }

    @Transactional
    public void delete(int id) {
        subjectRepository.deleteById(id);
    }
}
