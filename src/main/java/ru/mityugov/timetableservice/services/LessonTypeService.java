package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.LessonType;
import ru.mityugov.timetableservice.repositories.LessonTypeRepository;

import java.util.List;

@Service
public class LessonTypeService {

    private final LessonTypeRepository lessonTypeRepository;

    @Autowired
    public LessonTypeService(LessonTypeRepository lessonTypeRepository) {
        this.lessonTypeRepository = lessonTypeRepository;
    }

    public List<LessonType> findAll() {
        return lessonTypeRepository.findAll();
    }

    public LessonType findById(int id) {
        return lessonTypeRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(LessonType lessonType) {
        lessonTypeRepository.save(lessonType);
    }

    @Transactional
    public void update(int id, LessonType updatedLessonType) {
        updatedLessonType.setId(id);
        lessonTypeRepository.save(updatedLessonType);
    }

    @Transactional
    public void delete(int id) {
        lessonTypeRepository.deleteById(id);
    }
}
