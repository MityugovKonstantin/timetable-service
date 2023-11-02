package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.Subject;
import ru.mityugov.timetableservice.services.SubjectService;

@Controller
@RequestMapping("/subjects")
public class SubjectController {

    private final SubjectService subjectService;

    @Autowired
    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping()
    public String showSubjects(Model model) {
        model.addAttribute("subjects", subjectService.findAll());
        return "subjects/subjects";
    }

    @GetMapping("/{id}")
    public String showSubject(@PathVariable("id") int id, Model model) {
        model.addAttribute("subject", subjectService.findById(id));
        return "subjects/subject";
    }

    @GetMapping("/add")
    public String showAdditionalPage(@ModelAttribute("subject") Subject subject) {
        return "subjects/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("subject", subjectService.findById(id));
        return "subjects/updating";
    }

    @PostMapping("/add")
    public String addSubject(@ModelAttribute("subject") @Valid Subject subject, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "subjects/adding";
        subjectService.save(subject);
        return "redirect:/subjects";
    }

    @PatchMapping("/{id}/update")
    public String updateSubject(@PathVariable("id") int id,
                               @ModelAttribute("subject") @Valid Subject subject,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "subjects/updating";
        subjectService.update(id, subject);
        return "redirect:/subjects";
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable("id") int id) {
        subjectService.delete(id);
        return "redirect:/subjects";
    }
}
