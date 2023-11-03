package ru.mityugov.timetableservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.mityugov.timetableservice.entities.Lesson;
import ru.mityugov.timetableservice.repositories.LessonRepository;

import java.util.List;

@Service
public class LessonService {

    private final LessonRepository lessonRepository;

    @Autowired
    public LessonService(LessonRepository lessonRepository) {
        this.lessonRepository = lessonRepository;
    }

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Lesson findById(int id) {
        return lessonRepository.findById(id).orElse(null);
    }

    @Transactional
    public void save(Lesson lesson) {
        lessonRepository.save(lesson);
    }

    @Transactional
    public void update(int id, Lesson updatedLesson) {
        updatedLesson.setId(id);
        lessonRepository.save(updatedLesson);
    }

    @Transactional
    public void delete(int id) {
        lessonRepository.deleteById(id);
    }
}
