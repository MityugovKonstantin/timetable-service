package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.Teacher;
import ru.mityugov.timetableservice.services.DegreeService;
import ru.mityugov.timetableservice.services.TeacherService;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    private final TeacherService teacherService;
    private final DegreeService degreeService;

    @Autowired
    public TeacherController(TeacherService teacherService, DegreeService degreeService) {
        this.teacherService = teacherService;
        this.degreeService = degreeService;
    }

    @GetMapping()
    public String showTeachers(Model model) {
        model.addAttribute("teachers", teacherService.findAll());
        return "teachers/teachers";
    }

    @GetMapping("/{id}")
    public String showTeacher(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        return "teachers/teacher";
    }

    @GetMapping("/add")
    public String showAddingPage(@ModelAttribute("teacher") Teacher teacher, Model model) {
        model.addAttribute("degrees", degreeService.findAll());
        return "teachers/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("teacher", teacherService.findById(id));
        model.addAttribute("degrees", degreeService.findAll());
        return "teachers/updating";
    }

    @PostMapping("/add")
    public String addTeacher(@ModelAttribute("teacher") @Valid Teacher teacher,
                             BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "teachers/adding";
        teacherService.save(teacher);
        return "redirect:/teachers";
    }

    @PatchMapping("/{id}/update")
    public String updateTeacher(
            @ModelAttribute("teacher") @Valid Teacher teacher,
            BindingResult bindingResult,
            @PathVariable("id") int id
    ) {
        if (bindingResult.hasErrors())
            return "teachers/updating";
        teacherService.update(id, teacher);
        return "redirect:/teachers";
    }

    @DeleteMapping("/{id}")
    public String deleteTeacher(@PathVariable("id") int id) {
        teacherService.delete(id);
        return "redirect:/teachers";
    }
}
