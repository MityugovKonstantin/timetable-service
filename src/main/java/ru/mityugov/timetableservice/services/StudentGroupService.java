package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.StudentGroup;
import ru.mityugov.timetableservice.repositories.StudentGroupRepository;

import java.util.List;

@Service
public class StudentGroupService {

    private final StudentGroupRepository studentGroupRepository;

    @Autowired
    public StudentGroupService(StudentGroupRepository studentGroupRepository) {
        this.studentGroupRepository = studentGroupRepository;
    }

    public List<StudentGroup> findAll() {
        return studentGroupRepository.findAll();
    }

    public StudentGroup findById(int id) {
        return studentGroupRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(StudentGroup lessonType) {
        studentGroupRepository.save(lessonType);
    }

    @Transactional
    public void update(int id, StudentGroup updatedStudentGroup) {
        updatedStudentGroup.setId(id);
        studentGroupRepository.save(updatedStudentGroup);
    }

    @Transactional
    public void delete(int id) {
        studentGroupRepository.deleteById(id);
    }
}
