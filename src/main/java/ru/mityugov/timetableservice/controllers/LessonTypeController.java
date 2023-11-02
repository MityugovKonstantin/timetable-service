package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.LessonType;
import ru.mityugov.timetableservice.services.LessonTypeService;

@Controller
@RequestMapping("/lessonTypes")
public class LessonTypeController {

    private final LessonTypeService lessonTypeService;

    @Autowired
    public LessonTypeController(LessonTypeService lessonTypeService) {
        this.lessonTypeService = lessonTypeService;
    }

    @GetMapping()
    public String showLessonTypes(Model model) {
        model.addAttribute("lessonTypes", lessonTypeService.findAll());
        return "lessonTypes/lessonTypes";
    }

    @GetMapping("/{id}")
    public String showLessonType(@PathVariable("id") int id, Model model) {
        model.addAttribute("lessonType", lessonTypeService.findById(id));
        return "lessonTypes/lessonType";
    }

    @GetMapping("/add")
    public String showAdditionalPage(@ModelAttribute("lessonType") LessonType lessonType) {
        return "lessonTypes/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("lessonType", lessonTypeService.findById(id));
        return "lessonTypes/updating";
    }

    @PostMapping("/add")
    public String addLessonType(
            @ModelAttribute("lessonType") @Valid LessonType lessonType,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return "lessonTypes/adding";
        lessonTypeService.save(lessonType);
        return "redirect:/lessonTypes";
    }

    @PatchMapping("/{id}/update")
    public String updateLessonType(@PathVariable("id") int id,
                               @ModelAttribute("lessonType") @Valid LessonType lessonType,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "lessonTypes/updating";
        lessonTypeService.update(id, lessonType);
        return "redirect:/lessonTypes";
    }

    @DeleteMapping("/{id}")
    public String deleteLessonType(@PathVariable("id") int id) {
        lessonTypeService.delete(id);
        return "redirect:/lessonTypes";
    }
}
