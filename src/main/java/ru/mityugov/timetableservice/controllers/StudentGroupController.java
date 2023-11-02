package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.StudentGroup;
import ru.mityugov.timetableservice.services.StudentGroupService;

@Controller
@RequestMapping("/studentGroups")
public class StudentGroupController {

    private final StudentGroupService studentGroupService;

    @Autowired
    public StudentGroupController(StudentGroupService studentGroupService) {
        this.studentGroupService = studentGroupService;
    }

    @GetMapping()
    public String showLessonTypes(Model model) {
        model.addAttribute("studentGroups", studentGroupService.findAll());
        return "studentGroups/studentGroups";
    }

    @GetMapping("/{id}")
    public String showLessonType(@PathVariable("id") int id, Model model) {
        model.addAttribute("studentGroup", studentGroupService.findById(id));
        return "studentGroups/studentGroup";
    }

    @GetMapping("/add")
    public String showAdditionalPage(@ModelAttribute("studentGroup") StudentGroup studentGroup) {
        return "studentGroups/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("studentGroup", studentGroupService.findById(id));
        return "studentGroups/updating";
    }

    @PostMapping("/add")
    public String addLessonType(
            @ModelAttribute("studentGroup") @Valid StudentGroup studentGroup,
            BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors())
            return "studentGroups/adding";
        studentGroupService.save(studentGroup);
        return "redirect:/studentGroups";
    }

    @PatchMapping("/{id}/update")
    public String updateLessonType(@PathVariable("id") int id,
                                   @ModelAttribute("studentGroup") @Valid StudentGroup studentGroup,
                                   BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "studentGroups/updating";
        studentGroupService.update(id, studentGroup);
        return "redirect:/studentGroups";
    }

    @DeleteMapping("/{id}")
    public String deleteLessonType(@PathVariable("id") int id) {
        studentGroupService.delete(id);
        return "redirect:/studentGroups";
    }
}
