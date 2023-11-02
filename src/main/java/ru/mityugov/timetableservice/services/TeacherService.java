package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.Teacher;
import ru.mityugov.timetableservice.repositories.TeacherRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

    public Teacher findById(int id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    @Transactional
    public void update(int id, Teacher updatedTeacher) {
        updatedTeacher.setId(id);
        teacherRepository.save(updatedTeacher);
    }

    @Transactional
    public void delete(int id) {
        teacherRepository.deleteById(id);
    }
}
