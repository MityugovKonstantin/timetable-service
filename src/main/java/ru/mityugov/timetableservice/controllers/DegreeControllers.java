package ru.mityugov.timetableservice.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.mityugov.timetableservice.entities.Degree;
import ru.mityugov.timetableservice.services.DegreeService;

@Controller
@RequestMapping("/degrees")
public class DegreeControllers {

    private final DegreeService degreeService;

    @Autowired
    public DegreeControllers(DegreeService degreeService) {
        this.degreeService = degreeService;
    }

    @GetMapping()
    public String showDegrees(Model model) {
        model.addAttribute("degrees", degreeService.findAll());
        return "degrees/degrees";
    }

    @GetMapping("/{id}")
    public String showDegree(@PathVariable("id") int id, Model model) {
        model.addAttribute("degree", degreeService.findById(id));
        return "degrees/degree";
    }

    @GetMapping("/add")
    public String showAdditionalPage(@ModelAttribute("degree") Degree degree) {
        return "degrees/adding";
    }

    @GetMapping("/{id}/update")
    public String showUpdatingPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("degree", degreeService.findById(id));
        return "degrees/updating";
    }

    @PostMapping("/add")
    public String addDegree(@ModelAttribute("degree") @Valid Degree degree, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "degrees/adding";
        degreeService.save(degree);
        return "redirect:/degrees";
    }

    @PatchMapping("/{id}/update")
    public String updateDegree(@PathVariable("id") int id,
                               @ModelAttribute("degree") @Valid Degree degree,
                               BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return "degrees/updating";
        degreeService.save(degree);
        return "redirect:/degrees";
    }

    @DeleteMapping("/{id}")
    public String deleteDegree(@PathVariable("id") int id) {
        degreeService.delete(id);
        return "redirect:/degrees";
    }
}
