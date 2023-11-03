package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.Lesson;
import ru.mityugov.timetableservice.entities.LessonType;
import ru.mityugov.timetableservice.entities.Subject;
import ru.mityugov.timetableservice.services.LessonService;
import ru.mityugov.timetableservice.services.LessonTypeService;
import ru.mityugov.timetableservice.services.SubjectService;

@Controller
@RequestMapping("/lessons")
public class LessonController {

    private final LessonService lessonService;
    private final LessonTypeService lessonTypeService;
    private final SubjectService subjectService;

    @Autowired
    public LessonController(LessonService lessonService, LessonTypeService lessonTypeService, SubjectService subjectService) {
        this.lessonService = lessonService;
        this.lessonTypeService = lessonTypeService;
        this.subjectService = subjectService;
    }

    @GetMapping()
    public String showLessons(Model model) {
        model.addAttribute("lessons", lessonService.findAll());
        return "lessons/lessons";
    }

    @GetMapping("/{id}")
    public String showLesson(@PathVariable("id") int id, Model model) {
        model.addAttribute("lesson", lessonService.findById(id));
        return "lessons/lesson";
    }

    @GetMapping("/add")
    public String showAdditionalPage(
            @ModelAttribute("lesson") Lesson lesson,
            Model model
    ) {
        model.addAttribute("lesson_types", lessonTypeService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "lessons/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("lesson", lessonService.findById(id));
        model.addAttribute("lesson_types", lessonTypeService.findAll());
        model.addAttribute("subjects", subjectService.findAll());
        return "lessons/updating";
    }

    @PostMapping("/add")
    public String addLesson(@ModelAttribute("lesson") @Valid Lesson lesson, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lesson_types", lessonTypeService.findAll());
            model.addAttribute("subjects", subjectService.findAll());
            return "lessons/adding";
        }
        lessonService.save(lesson);
        return "redirect:/lessons";
    }

    @PatchMapping("/{id}/update")
    public String updateLesson(@PathVariable("id") int id,
                               @ModelAttribute("lesson") @Valid Lesson lesson,
                               BindingResult bindingResult,
                               Model model
    ) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("lesson_types", lessonTypeService.findAll());
            model.addAttribute("subjects", subjectService.findAll());
            return "lessons/updating";
        }
        lessonService.update(id, lesson);
        return "redirect:/lessons";
    }

    @DeleteMapping("/{id}")
    public String deleteLesson(@PathVariable("id") int id) {
        lessonService.delete(id);
        return "redirect:/lessons";
    }
}
